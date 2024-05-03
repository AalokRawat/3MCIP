package design.api.limiter.algorithms;

import design.api.limiter.ApiRateLimiter;
import design.api.limiter.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TokenBucket implements ApiRateLimiter {

    private int bucketCapacity;
    private AtomicInteger nTokens;
    private long frequency;
    Lock lock;

    public TokenBucket(Configuration configuration) {
        this.setConfiguration(configuration);
        this.lock = new ReentrantLock();
        this.refill();
    }

    @Override
    public boolean execute() {
        lock.lock();
        try {
            if (nTokens.get() > 0) {
                nTokens.decrementAndGet();
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void setConfiguration(Configuration configuration) {
        this.bucketCapacity = configuration.getNRequests();
        this.nTokens = new AtomicInteger(configuration.getNRequests());
        this.frequency = configuration.getTimeUnit().toMillis(configuration.getRateLimit()) /configuration.getNRequests();
    }

    private void refill() {
        ScheduledExecutorService executorService =  Executors.newScheduledThreadPool(1);
        executorService.scheduleWithFixedDelay(() -> {
            lock.lock();
            try {
                if (nTokens.get() < bucketCapacity)
                    nTokens.incrementAndGet();
            } finally {
                lock.unlock();
            }
        }, frequency, frequency, TimeUnit.MILLISECONDS);
    }
}
