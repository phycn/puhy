package phy.io.serial;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
    
    public static void main(String ... args) throws IOException, ClassNotFoundException {
        
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\phytest\\object.txt"));
        //从输入流中读取java对象，并强制类型转换为person类
        Person p = (Person)ois.readObject();
        System.out.println("姓名：" + p.getName());
        //因为age字段不能被序列化，所以获取不到值
        System.out.println("年龄：" + p.getAge());
        ois.close();
    }    
}
