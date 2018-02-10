package phy.multithreading;

public class ThreadGroupTest extends Thread{
    
    public ThreadGroupTest(String name) {
        super(name);
    }
    
    public ThreadGroupTest(ThreadGroup group, String name) {
        super(group, name);
    }
    
    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            System.out.println(getName() + "---" + i);
        }
    }
    
    public static void main(String ... args) {
        
        //获取主线程所在的线程组，所有线程默认的线程组
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("主线程名字：" + mainGroup.getName());
        System.out.println("主线程是否是后台线程组：" + mainGroup.isDaemon());
        new ThreadGroupTest("主线程组的线程").start();
        
        ThreadGroup tg = new ThreadGroup("新线程组");
        new ThreadGroupTest(tg,"新线程组的线程").start();
    }
}
