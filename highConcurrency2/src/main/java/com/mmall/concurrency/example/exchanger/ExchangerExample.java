package com.mmall.concurrency.example.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author puhongyu
 * 2018/9/29 10:07
 */
public class ExchangerExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Exchanger exchanger = new Exchanger();

        executor.execute(new Thread(() -> {
            String data = "蒲红宇";
            doExchangeWork(data, exchanger);
        }, "线程1"));

        executor.execute(new Thread(() -> {
            String data = "周佳静";
            doExchangeWork(data, exchanger);
        }, "线程2"));

        executor.shutdown();
    }

    private static void doExchangeWork(String data, Exchanger exchanger) {

        try {
            System.out.println(Thread.currentThread().getName() + "正在把数据 [" + data + "] 交换出去");
            Thread.sleep(3000);
            String data2 = (String) exchanger.exchange(data);
            System.out.println(Thread.currentThread().getName() + "交换到数据  [" + data2 + "]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
