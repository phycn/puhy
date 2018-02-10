package cn.puhy.springmvc.domain;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class User {

    //正则表达式校验
    @Pattern(regexp = "w{4,30}")
    private String name;

    private String password;

    private int age;

    private String address;

    @Past   //必须是一个过去的时间，@Future为将来的时间
    @DateTimeFormat(pattern = "yyyy-MM-dd") //将形如1999-12-12的字符串转换为Date类型
    private Date birthday;

    @DecimalMin("1000.00")      //最小值
    @DecimalMax("100000.00")    //最大值
    @NumberFormat(pattern = "####.##")  //将形如1200.99的字符串转换为double类型
    private double salary;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", salary=" + salary +
                '}';
    }
}
