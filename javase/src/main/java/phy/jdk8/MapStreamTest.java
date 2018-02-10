package phy.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapStreamTest {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("张三", "28", "男"));
        personList.add(new Person("李四", "39", "女"));
        personList.add(new Person("王五", "12", "女"));
        personList.add(new Person("赵六", "36", "男"));

        String[] array = {"phy", "puhongyu", "puhy", "redis", "mysql"};

        //返回所有女性的姓名
        Stream<String> ps1 = personList.stream().filter(person -> "女".equals(person.getSex())).map(Person::getName);
        ps1.forEach(name -> {
            System.out.println(name);
        });

        //获取array数组中所有元素的字母，去重
        List<String> letter = Arrays.stream(array)
                .map(str -> str.split(""))  //映射成为Stream<String[]>
                .flatMap(ar -> Arrays.stream(ar))   //扁平化为Stream<String>
                .distinct()
                .collect(Collectors.toList());
        System.out.println(letter);

        //返回一个新流
        Stream<Person> ps2 = personList.stream().map(person -> new Person(person.getName(), person.getAge()));
        ps2.forEach(person -> {
            System.out.println(person.getName() + "  " + person.getAge());
        });

        //allMatch用于检测是否全部都满足指定的条件
        boolean b1 = personList.stream().allMatch(person -> Integer.parseInt(person.getAge()) > 20);
        System.out.println(b1);

        //anyMatch用于检测是否存在一个或多个满足指定的条件
        boolean b2 = personList.stream().anyMatch(person -> Integer.parseInt(person.getAge()) > 20);
        System.out.println(b2);

        //noneMatch用于检测是否不存在满足指定的条件
        boolean b3 = personList.stream().noneMatch(person -> Integer.parseInt(person.getAge()) > 100);
        System.out.println(b3);

        //findFirst用于返回满足条件的第一个元素
        Optional<Person> op1 = personList.stream().findFirst();
        op1.ifPresent(person -> {
            System.out.println(person.getName());
        });

        //findAny用于返回任意一个，在并行流中性能比findFirst要好
        Optional<Person> op2 = personList.stream().findAny();
        op2.ifPresent(person -> {
            System.out.println(person.getName());
        });
    }
}

class Person {

    private String name;
    private String age;
    private String sex;

    public Person(String name, String age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
