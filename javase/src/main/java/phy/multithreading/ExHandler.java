package phy.multithreading;

public class ExHandler {
    
    public static void main(String ... args) {
    
        //设置主线程的异常处理器
        Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
        int a = 5/0;
        System.out.println("正常结束");
    }
}

//自定义异常处理器
class MyExHandler implements Thread.UncaughtExceptionHandler {

    @Override
    //实现uncaughtException()方法，处理线程的未处理异常
    public void uncaughtException(Thread t, Throwable e) {
        
        System.out.println(t + "线程出现了异常：" + e);
    }   
}
