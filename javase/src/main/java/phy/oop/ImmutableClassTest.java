/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phy.oop;

/**
 *
 * @author Administrator
 */
public class ImmutableClassTest {

    private final Name name;

    public ImmutableClassTest(Name name) {
        
        //设置name字段为临时创建的Name对象，该对象的firstName和lastName与传入的name对象的firstName和lastName相同
        this.name = new Name(name.getFirstName(), name.getLastName());
    }

    public Name getName() {
        
        //返回一个匿名对象
        return new Name(name.getFirstName(), name.getLastName());
    }
    
    public static void main(String ... args) {
        
        Name n = new Name("蒲","红宇");   
        ImmutableClassTest p = new ImmutableClassTest(n);
        System.out.println(p.getName().getFirstName());
        n.setFirstName("傻逼");
        //可以看到firstName的值并没有变化
        System.out.println(p.getName().getFirstName());
    }
}

class Name {

    private String firstName;
    private String lastName;

    public Name() {

    }

    public Name(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
