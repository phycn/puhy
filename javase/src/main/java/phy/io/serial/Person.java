package phy.io.serial;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Serializable{
    
    private String name;
    //transient修饰的字段不会被序列化
    private transient int age;
    
    public Person(String name, int age) {
        
        System.out.println("有参数的构造器");
        this.name = name;
        this.age = age;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }
    
    //自定义序列化
    private void writeObject(ObjectOutputStream out) throws IOException {
        
        out.writeObject(new StringBuffer(name).reverse());
         
    }
    //自定义序列化
    private void readObject(ObjectInputStream in) throws Exception {
        
        this.name = ((StringBuffer)in.readObject()).reverse().toString();
    }
}
