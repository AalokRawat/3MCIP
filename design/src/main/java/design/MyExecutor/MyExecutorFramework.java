package design.MyExecutor;

import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

class MyExecutors {

    public static MyExecutorService getSingleThreadPool() {
        return new MyThreadPool(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    }

    public static MyExecutorService getFixedThreadPool(int n) {
        return new MyThreadPool(n, n, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    }

    public static MyExecutorService getCachedThreadPool() {
        return new MyThreadPool(0, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    }
}

interface MyExecutorService {

    void execute(Runnable r);
    Future<?> submit(Runnable r);
    <T> Future<T> submit(Runnable r, T result);
    <T> Future<T> submit(Callable<T> c);

}

class MyThreadPool implements MyExecutorService {

    private volatile int corePoolSize;
    private volatile int maxPoolSize;
    private volatile long keepAliveTime;
    private final BlockingQueue<Runnable> workQueue;
    private final HashSet<Workers> workers = new HashSet<>();

    public MyThreadPool(int corePoolSize, int maxPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.keepAliveTime = unit.toMillis(keepAliveTime);
        this.workQueue = workQueue;
    }

    @Override
    public void execute(Runnable r) {
        if (workers.size() < corePoolSize || workers.size() == 0) {
            Workers w = new Workers(r);
            w.thread.start();
            workers.add(w);
        } else if (workers.stream().anyMatch(worker -> worker.isAvailable)) {
            workQueue.add(r);
        } else if (workers.size() < maxPoolSize) {
            Workers w = new Workers(r);
            w.thread.start();
            workers.add(w);
        } else {
            workQueue.add(r);
        }
    }

    @Override
    public Future<?> submit(Runnable r) {
        return submit(r, null);
    }

    @Override
    public <T> Future<T> submit(Runnable r, T result) {
        FutureTask future = new FutureTask<>(r, result);
        execute(future);
        return future;
    }

    @Override
    public <T> Future<T> submit(Callable<T> c) {
        FutureTask future = new FutureTask<>(c);
        execute(future);
        return future;
    }

    class Workers extends AbstractQueuedSynchronizer implements Runnable {
        private Thread thread;
        private Runnable task;
        long availableSince = 0;
        private volatile boolean isAvailable;

        public Workers(Runnable task) {
            this.task = task;
            this.thread = new Thread(this);
        }

        @Override
        public void run() {
            runWorker();
        }

        private void runWorker() {
            System.currentTimeMillis();
            while (true) {
                if (task != null) {
                    this.setAvailable(false);
                    task.run();
                } else {
                    this.setAvailable(true);
                    if (!keepAlive()) {
                        return;
                    }
                }
                task = workQueue.poll();
            }
        }

        private boolean keepAlive() {
            if (keepAliveTime!=0 && System.currentTimeMillis() - availableSince >= keepAliveTime) {
                return false;
            }
            return true;
        }

        public void setAvailable(boolean available) {
            if (available == false) {
                isAvailable = false;
                availableSince = 0;
            } else {
                isAvailable = true;
                if (availableSince == 0) {
                    availableSince = System.currentTimeMillis();
                }
            }
        }
    }
}

public class MyExecutorFramework {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Getting the object of MyExcutorService by using
        //  the factory method myNewFixedThreadPool

        // Passing number of threads as 3
        MyExecutorService service = MyExecutors.getFixedThreadPool(3);
        ExecutorService e = Executors.newFixedThreadPool(1);
        final String[] mutable = new String[1];
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                mutable[0] = "Test";
            }
        };

        Callable<String[]> c = new Callable() {
            @Override
            public Object call() throws Exception {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                return new String[]{"Test 1"};
            }
        };

        String[] f =  e.submit(r, mutable).get();
        System.out.println("output: "+ f[0]);

        f =  e.submit(c).get();
        System.out.println("output: "+ f[0]);

        f =  service.submit(r, mutable).get();
        System.out.println("output: "+ f[0]);

        f =  service.submit(c).get();
        System.out.println("output: "+ f[0]);

//        for (int i = 0; i < 20; i++) {
//
//            // Creating 20 tasks and passing them to execute
//            service.execute(new Mytask());
//            Thread.sleep(10);
//        }
    }
}

class Mytask implements Runnable {

    // Method 1 of this class
    // @Override
    public void run() {

        // Try block to check for exceptions
        try {

            // Making thread to pause for a second
            // using sleep() method
            Thread.sleep(1);
        }

        // Catch block to check for exceptions
        catch (InterruptedException e) {

            // Print the exception scaling ith line number
            // using printStackTrace() method
            e.printStackTrace();
        }

        // Print and display the current thread using
        // currentThread() method by getting thread name
        // using getName() method
        System.out.println(
                "Current Thread :-> "
                        + Thread.currentThread().getName());
    }
}
