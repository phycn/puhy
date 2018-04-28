package cn.puhy.highConcurrency.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 无锁的对象引用
 * 对象的值被修改多次，而经过多次修改后对象的值又恢复旧值，其他线程无法判断是否被修改
 *
 * @author puhongyu
 */
public class AtomicReferenceDemo {

    private static AtomicReference<Integer> money = new AtomicReference<>();

    /**
     * 模拟充值，业务场景为余额低于20自动充值，最多只能一次，事实上充值多次
     *
     * @author puhongyu
     */
    private static class Add implements Runnable {

        @Override
        public void run() {
            while (true) {
                Integer m = money.get();
                if (m < 20) {
                    //第一个参数为期望值，第二个参数为新值
                    if (money.compareAndSet(m, m + 20)) {
                        System.out.println("充值成功，余额：" + money.get());
                    }
                } else {
                    System.out.println("余额大于20，无需充值");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
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
                Integer m = money.get();
                if (m > 10) {
                    if (money.compareAndSet(m, m - 10)) {
                        System.out.println("消费10，余额：" + money.get());
                    }
                } else {
                    System.out.println("余额不足");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        money.set(19);
        new Thread(new Add()).start();
        new Thread(new Consume()).start();
    }
}
