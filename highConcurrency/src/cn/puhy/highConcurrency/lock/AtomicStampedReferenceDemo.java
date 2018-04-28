package cn.puhy.highConcurrency.lock;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 带有时间戳的无锁对象引用
 *
 * @author puhongyu
 */
public class AtomicStampedReferenceDemo {

    private static AtomicStampedReference<Integer> money = new AtomicStampedReference<>(19, 0);

    /**
     * 模拟充值，业务场景为余额低于20自动充值
     *
     * @author puhongyu
     */
    private static class Add implements Runnable {

        @Override
        public void run() {
            int stampe = money.getStamp();
            while (true) {
                Integer m = money.getReference();
                if (m < 20) {
                    //对象值与时间戳都满足期望值才会更新
                    System.out.println(stampe);
                    System.out.println(money.getStamp());
                    if (money.compareAndSet(m, m + 20, stampe, stampe + 1)) {
                        System.out.println("充值成功，余额：" + money.getReference());
                    }
                } else {
                    System.out.println("余额大于20，无需充值");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 模拟消费
     *
     * @author puhongyu
     */
    private static class Consume implements Runnable {

        @Override
        public void run() {
            while (true) {
                Integer m = money.getReference();
                int stampe = money.getStamp();
                if (m > 10) {
                    if (money.compareAndSet(m, m - 10, stampe, stampe + 1)) {
                        System.out.println("消费10，余额：" + money.getReference());
                    }
                } else {
                    System.out.println("余额不足");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        new Thread(new Add()).start();
        new Thread(new Consume()).start();
    }
}
