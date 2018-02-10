package cn.puhy.spring.spel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User {

    public User() {

    }

    public User(int age) {
        this.age = age;
    }

    private int age;
    private String name;
    public boolean boo;
    private List<String> list;
    private Map<String, String> map;
    private double randomNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public String info() {
        return "哈哈，我是蒲红宇";
    }

    public static String hehe() {
        return "我是静态方法呢，你看啥呢";
    }

    public int getAge() {
        return age;
    }

    public double getRandomNum() {
        return randomNum;
    }

    public void setRandomNum(double randomNum) {
        this.randomNum = randomNum;
    }
}
