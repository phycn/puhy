package test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import test.suning.Head;
import test.suning.RequestBean;
import test.suning.ResponseBean;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Test {

    static int a;

    static {
        a = 22;
        System.out.println("1111");
    }

    public static void aa() {
        System.out.println("222");
    }
    
    public static void main(String[] args) throws Exception {
        aa();
        aa();
        aa();
    }
}


