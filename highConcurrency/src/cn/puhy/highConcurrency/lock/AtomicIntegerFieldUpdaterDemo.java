package cn.puhy.highConcurrency.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterDemo {

    public static class Candidate {
        int id;
        volatile int score;
    }

    //变量必须为可见的，不能为private,也不能为static；必须用volatile修饰
    static AtomicIntegerFieldUpdater<Candidate> update = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");

    static AtomicInteger all = new AtomicInteger();

    static Candidate c = new Candidate();

    public static class Add implements Runnable {


        @Override
        public void run() {
            if (Math.random() > 0.4) {
                update.incrementAndGet(c);
                all.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new Add());
            t.start();
            t.join();
        }

        //总是相等的
        System.out.println(c.score);
        System.out.println(all);
    }
}
