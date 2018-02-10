/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phy.reflection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class CustomizeClassLoaderTest extends ClassLoader {
    
    //读取文件内容
    private byte[] getBytes(String fileName) throws IOException {
        
        File file = new File(fileName);
        long len = file.length();
        byte[] raw = new byte[(int)len];
        try {
            FileInputStream fis = new FileInputStream(file);
            int r = fis.read(raw);
            if(r != len) {
                throw new IOException("无法读取全部文件");
            }
        }
        catch(Exception e) {
            
        }
        return raw;
    }
    
    //定义编译指定Java文件的方法
    private boolean compile(String javaFile) throws IOException {
        
        System.out.println("编译" + javaFile);
        //调用系统的javac命令
        Process p = Runtime.getRuntime().exec("javac " + javaFile);
        try {
            //其他线程等待这个线程完成
            p.waitFor();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        //获取javac的返回值
        int ret = p.exitValue();
        return ret == 0;
    }
    
    //重写findClass方法
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        
        Class clazz = null;
        String fileStub = name.replace(".", "/");
        String javaFileName = fileStub + ".java";
        String classFileName = fileStub + ".class";
        File javaFile = new File(javaFileName);
        File classFile = new File(classFileName);
        
        //当指定java源文件存在，且Class文件不存在，或者java源文件的修改时间比Class文件的修改时间晚，重新编译
        if(javaFile.exists() && !classFile.exists() || javaFile.lastModified() > classFile.lastModified()) {
            
            try {
                if(!compile(javaFileName) || !classFile.exists()) {
                    throw new ClassNotFoundException("ClassNotFoundException:" + javaFileName);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        if(classFile.exists()) {
            
            try {
                byte[] raw = getBytes(classFileName);
                //调用ClassLoader的defineClass方法将二进制数据转换为Class对象
                clazz = defineClass(name, raw, 0 , raw.length);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        //如果clazz为null，表明加载失败
        if(clazz == null) {
            throw new ClassNotFoundException(name);
        }
        return clazz;
    }
    
    public static void main(String[] args) throws Exception {
        
        //如果运行该程序没有参数，既没有目标类
        if(args.length < 1) {
            
            System.out.println("缺少目标类");
            System.out.println("java CustomizeClassLoaderTest className");
        }
        //第一个参数是需要运行的类
        String progClass  = args[0];
        //剩下的参数将作为运行目标类时的参数
        //将这些参数复制到一个新数组中
        String[] progArgs = new String[args.length - 1];
        System.arraycopy(args, 1, progArgs, 0, progArgs.length);
        CustomizeClassLoaderTest ccl = new CustomizeClassLoaderTest();
        //加载需要运行的类
        Class<?> clazz = ccl.findClass(progClass);
        //获取需要运行的类的主方法
        Method main = clazz.getMethod("main", (new String[0]).getClass());
        Object argsArray[] = {progArgs};
        main.invoke(null, argsArray);
    }
}
