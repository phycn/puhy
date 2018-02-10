package phy.oop;

public enum ParmEnum {
    
    //此处的枚举值必须调用对应的构造器来创建
    //相当于public static final ParmEnum MALE = new ParmEnum("男");
    MALE("男"),FEMALE("女");
    private final String name;
    private ParmEnum(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
}
