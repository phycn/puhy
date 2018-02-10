package phy.system;

public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {

        User u1 = new User(24);
        User u2 = u1.clone();
        //不相同，u2相当于u1的副本
        System.out.println(u1 == u2);
    }
}

class Address {

    String name;

    public Address(String name) {
        this.name = name;
    }
}
//实现Cloneable接口

class User implements Cloneable {

    int age;
    Address address;

    public User(int age) {
        this.age = age;
        address = new Address("湖北武汉");
    }

    @Override
    public User clone() throws CloneNotSupportedException {

        //通过调用super.clone()来实现clone()方法
        return (User) super.clone();
    }
}
