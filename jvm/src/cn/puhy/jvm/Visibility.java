package cn.puhy.jvm;

/**
 * 可见性问题
 *
 * @author puhongyu
 * 2018/4/16 20:30
 */
public class Visibility extends Thread {

    private boolean stop = false;

    @Override
    public void run() {
        long i = 0;
        while (!stop) {
            i++;
        }
        System.out.println(i);
    }

    private synchronized void setStop() {
        this.stop = true;
    }

    public static void main(String[] args) throws InterruptedException {
        Visibility cr = new Visibility();
        //可见性问题，主线程对stop变量的修改无法反应到cr线程里去
        //解决办法是stop变量用volatile
        cr.start();
        Thread.sleep(1000);
        cr.setStop();
    }
}
