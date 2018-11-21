package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                Main main = new Main();
                main.phytest();
            }).start();
        }
    }

    public void phytest() {
        CountDownLatch cdl = new CountDownLatch(5);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Run1(list, cdl));
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }

    private class Run1 implements Runnable {

        private List<String> list;
        private CountDownLatch cdl;

        Run1(List<String> list, CountDownLatch cdl) {
            this.list = list;
            this.cdl = cdl;
        }

        @Override
        public void run() {
            list.add("1212");
            cdl.countDown();
        }
    }
}
