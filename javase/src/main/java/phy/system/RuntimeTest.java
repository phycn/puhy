package phy.system;

import java.io.IOException;

public class RuntimeTest {
    
    public static void main(String[] args) throws IOException {
        
        //获取java程序关联的运行时对象
        Runtime rt = Runtime.getRuntime();
        //CPU数量
        System.out.println(rt.availableProcessors());
        //虚拟机内存，不是系统内存
        System.out.println(rt.totalMemory());
        //可用最大内存
        System.out.println(rt.maxMemory());
        //执行window程序
        rt.exec("notepad.exe");
    }
}
