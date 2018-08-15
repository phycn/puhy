package cn.puhy.jvm;

/**
 * 有序性问题，解决办法是在有可能重排序的方法上加上synchronized
 */
public class Ordering {
    // 共享变量
    private boolean flag = false;
    private int a = 1;
    private int result = 0;

    // 写操作
    private void write() {
        // 这里有可能会发生指令重排
        flag = true;    //1
        a = 2;          //2
    }

    // 读操作
    private void read() {
        if (flag) {     //3
            result = a * 3;
        }
        System.out.println("result: " + result);
    }

    //有可能的执行顺序
    //1->2->3   6
    //1->3->2   3
    //2->1->3   6
    //2->3->1   0
    //3->1->2   0
    //3->2->1   0
    private class ReadWriteThread extends Thread {
        private boolean flag;

        ReadWriteThread(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            if (flag) {
                write();
            } else {
                read();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Ordering demo = new Ordering();
        demo.new ReadWriteThread(true).start();// 写
        demo.new ReadWriteThread(false).start();// 读
    }
}
