package design.MyExecutorRevision;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyExecutorFrameworkRevision {

    public static void main(String[] args) {
        MyExecutorService myExecutorService = MyExecutors.getFixedThreadPool(2);
        myExecutorService.execute(() -> {
            System.out.println(Thread.currentThread());
            System.out.println("Test");
        });
        myExecutorService.execute(() -> {
            System.out.println(Thread.currentThread());
            System.out.println("Test");
        });
        myExecutorService.execute(() -> {
            System.out.println(Thread.currentThread());
            System.out.println("Test");
        });
        myExecutorService.execute(() -> {
            System.out.println(Thread.currentThread());
            System.out.println("Test");
        });
    }
}


class MyExecutors {

    static MyExecutorService getSingleThreadPool() {
        return new MyThreadPool(1, 1);

    }

    static MyExecutorService getFixedThreadPool(int number) {
        return new MyThreadPool(number, number);
    }
}

interface MyExecutorService {
    void execute(Runnable r);
}

class MyThreadPool implements MyExecutorService {
    private int minThreads;
    private int maxThreads;
    private BlockingQueue<MyWorker> workers;
    private BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue();

    public MyThreadPool(int minThreads, int maxThreads) {
        this.minThreads = minThreads;
        this.maxThreads = maxThreads;
        this.workers = new ArrayBlockingQueue<>(maxThreads);

        for(int i=0; i<minThreads; i++) {
            MyWorker myWorker = new MyWorker();
            workers.add(myWorker);
            myWorker.start();
        }
    }

    @Override
    public void execute(Runnable r) {
        workQueue.add(r);

        if(workQueue.size()>workers.size()*2 && workers.size()<maxThreads) {
            MyWorker myWorker = new MyWorker();
            workers.add(myWorker);
            myWorker.start();
        }
    }

    class MyWorker extends Thread {
        Runnable task;

        @Override
        public void run() {
            while(true) {
                task = workQueue.poll();
                if(task!=null)
                    task.run();
            }
        }
    }
}