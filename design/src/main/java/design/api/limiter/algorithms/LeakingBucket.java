package design.api.limiter.algorithms;

import design.api.limiter.ApiRateLimiter;
import design.api.limiter.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LeakingBucket implements ApiRateLimiter {

    private int bucketSize;
    private AtomicInteger leakyBucket;
    private long leakingRate;
    private Lock lock;

    public LeakingBucket(Configuration configuration) {
        this.setConfiguration(configuration);
        this.lock = new ReentrantLock();
        this.process();
    }

    @Override
    public boolean execute() {
        lock.lock();
        try {
            if (leakyBucket.get() < bucketSize) {
                leakyBucket.incrementAndGet();
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void setConfiguration(Configuration configuration) {
        this.bucketSize = configuration.getNRequests();
        this.leakyBucket = new AtomicInteger(0);
        this.leakingRate = configuration.getTimeUnit().toMillis(configuration.getRateLimit()) /configuration.getNRequests();
    }

    private void process() {
        ScheduledExecutorService executorService =  Executors.newScheduledThreadPool(1);
        executorService.scheduleWithFixedDelay(() -> {
            lock.lock();
            try {
                if (leakyBucket.get() > 0)
                    leakyBucket.decrementAndGet();
            } finally {
                lock.unlock();
            }
        }, leakingRate, leakingRate, TimeUnit.MILLISECONDS);
    }
}
