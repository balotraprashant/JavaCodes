package MultiThreading;

public class ThreadYieldTest {
    public static void main(String[] args) throws InterruptedException{
        MyThread.mt=Thread.currentThread();
        MyThread t=new MyThread();
        t.start();
        for(int i=0;i<5;i++)
        {
            Thread.sleep(2000);
            System.out.println("Main Thread");
        }
    }
}

class MyThread extends Thread {
    static Thread mt;

    public void run() {
        try {
            mt.join();
        } catch (InterruptedException e) {
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread");
        }
    }
}
