//                   抛出异常   不同返回值(失败不会抛异常，返回null或false)  阻塞线程
//队尾插入元素       add(e)     offer(e)                                     put(e)
//对头删除元素       remove()   poll()                                       take()
//获取，不删除元素   element()  peek()                                       无

package phy.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
    
    public static void main(String ... args) {
        
        //创建容量为1的BlockingQueue
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
        
        new Producer(bq).start();
        new Producer(bq).start();
        new Producer(bq).start();
        
        new Consumer(bq).start();
    }
}

class Producer extends Thread {
    
    private BlockingQueue<String> bq;
    public Producer(BlockingQueue<String> bq) {
        
        this.bq = bq;
    }
    
    @Override
    public void run() {
        
        for(int i = 0; i < 10; i++) {
            
            System.out.println(getName() + "准备放入元素");
            try {
                Thread.sleep(100);
                //尝试放入元素，队列已满则线程堵塞
                bq.put("蒲红宇");
            } catch (Exception ex) {
                
            }
            System.out.println(getName() + "放入元素完毕");
        }
    }
}

class Consumer extends Thread {
    
    private BlockingQueue<String> bq;
    public Consumer(BlockingQueue<String> bq) {
        
        this.bq = bq;
    }
    
    @Override
    public void run () {
        
        while(true) {
            System.out.println(getName() + "准备取出元素");
            try {
                Thread.sleep(100);
                //尝试取出元素，如果队列已空，则线程阻塞
                bq.take();
            } catch (InterruptedException ex) {
                
            }
            System.out.println(getName() + "取出元素完毕");
        }
    }
}
    
