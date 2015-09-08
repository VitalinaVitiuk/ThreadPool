public class Task implements Runnable {
    private int argument;
    private int power;

    Task(int argument, int power) {
        this.argument = argument;
        this.power = power;
    }

    public void run() {
        System.out.println("THE RESULT IS " + Math.pow(argument, power) + " === " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        SimpleThreadPool simpleThreadPool = new SimpleThreadPool(3);

        Task t1 = new Task(2, 2);
        Task t2 = new Task(3, 3);
        Task t3 = new Task(4, 4);
        Task t4 = new Task(5, 5);
        Task t5 = new Task(6, 6);
        Task t6 = new Task(7, 7);
        Task t7 = new Task(8, 8);
        Task t8 = new Task(9, 9);
        Task t9 = new Task(10, 10);
        Task t10 = new Task(11, 9);
        Task t11 = new Task(8, 8);
        Task t12 = new Task(9, 9);

        simpleThreadPool.doTask(t1);
        simpleThreadPool.doTask(t2);
        simpleThreadPool.doTask(t3);
        simpleThreadPool.doTask(t4);
        simpleThreadPool.doTask(t5);
        simpleThreadPool.doTask(t6);
        simpleThreadPool.doTask(t7);
        simpleThreadPool.doTask(t8);
        simpleThreadPool.doTask(t9);
        simpleThreadPool.doTask(t10);
        simpleThreadPool.doTask(t11);
        simpleThreadPool.doTask(t12);
    }
}

