package phy.oop;

public class InterfaceEnum {

    public static void main(String[] args) {
        
        Gender g = Enum.valueOf(Gender.class, "MALE");
        
        g.info();
    }
}

interface Desc {
    
    void info();
}

enum Gender implements Desc {

    //每个枚举值都可以实现接口方法，表现出不同的行为
    MALE("男"){
        @Override
        public void info() {
            System.out.println("这个枚举值是男的");
        }
    },
    
    FEMALE("女"){
        @Override
        public void info() {
            System.out.println("这个枚举值是女的");
        }
    };
    private final String name;
    private Gender(String name) {
        this.name = name;
    } 
}
