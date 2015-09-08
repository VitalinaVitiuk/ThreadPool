import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SimpleThreadPool {
    private List<WorkerThread> threads;
    private LinkedList<Runnable> tasksQueue;
    private int threadNumber;

    public SimpleThreadPool(int threadNumber) {
        this.threadNumber = threadNumber;
        tasksQueue = new LinkedList<Runnable>();
        threads = new ArrayList<WorkerThread>();
    }


    private void enqueue(Runnable r) {
        synchronized (tasksQueue) {
            tasksQueue.addLast(r);
            tasksQueue.notifyAll();
        }
    }


    public void doTask(Runnable r) {
        if (threads.size() < threadNumber) {
            WorkerThread workerThread = new WorkerThread();
            threads.add(workerThread);
            workerThread.start();
            enqueue(r);
            return;
        } else {
            enqueue(r);
            return;
        }
    }


    private class WorkerThread extends Thread {

        public void run() {
            Runnable r;
            while (true) {
                synchronized (tasksQueue) {
                    while (tasksQueue.isEmpty()) {
                        try {
                            tasksQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    r = tasksQueue.removeFirst();
                }
                try {
                    r.run();
                } catch (Exception e) {
                }
            }
        }
    }
}
