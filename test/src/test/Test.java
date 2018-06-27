package test;

public class Test implements Runnable {

    private static Integer num = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new Test());
            thread.start();
            thread.join();
        }
    }

    @Override
    public void run() {
        System.out.println(num++);
    }
}


