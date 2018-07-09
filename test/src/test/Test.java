package test;


import java.io.IOException;
import java.net.URL;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ServiceLoader;

public class Test {
    public static void main(String[] args) throws IOException {
        Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources("test");
        while (dirs.hasMoreElements()) {
            URL url = dirs.nextElement();
            String path = url.getPath();
            System.out.println(path);

            //遍历目录下所有文件和目录
            Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>() {

                //访问文件时触发该方法
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String fileName = file.toFile().getName();
                    String className = "test." + fileName.substring(0, fileName.length() - 6);
                    try {
                        Class c = Class.forName(className);
                        Class[] cs = c.getInterfaces();
                        for (Class cc : cs) {
                            if (cc.getName().equals("test.MyInterface")) {
                                System.out.println(c.getName());
                                System.out.println(c.isAnnotationPresent(Autowired.class));
                            }
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    //代表继续访问的后续行为
                    return FileVisitResult.CONTINUE;
                }
            });
        }
    }
}


