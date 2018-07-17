package test;


import java.io.IOException;
import java.net.URL;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Test {
    public static void main(String[] args) throws IOException {

//        Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources("test");
//        while (dirs.hasMoreElements()) {
//            URL url = dirs.nextElement();
//            System.out.println(url.toString());
//        }

        JarFile jarFile = new JarFile("/Users/puhongyu/phy/bpf/liqiao/wlbatmp/lib/bpf-suning-api-1.0.jar");
        Enumeration<JarEntry> enumFiles = jarFile.entries();
        System.out.println(enumFiles.hasMoreElements());
        while (enumFiles.hasMoreElements()) {
            JarEntry jarEntry = enumFiles.nextElement();
            System.out.println(jarEntry.getName());
            if (jarEntry.getName().startsWith("META-INF")) {

            }
        }
    }
}


