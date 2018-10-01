principle                   设计原则
    openclose               开放封闭原则
    dependenceinversion     依赖倒置原则
    singleresponsibility    单一职责原则
    interfacesegregation    接口隔离原则
    demeter                 迪米特原则
    liskovsubstitution      里氏替换原则
    compositionaggregation  组合聚合复用原则

creational                  创建型设计模式
    simplefactory           简单工厂，并不属于23种之一
    factorymethod           工厂模式
    abstractfactory         抽象工厂模式，扩展产品等级困难
    builder                 建造者模式




singleton           单例模式
    Singleton1      懒汉式，线程不安全
    Singleton2      懒汉式，线程安全
    Singleton3      恶汉式，线程安全，没有懒加载
    Singleton4      双重锁，线程安全，高性能
    Singleton5      静态内部类实现
    Singleton6      枚举实现，最好的单例？

factory             工厂模式

abstractfactory     抽象工厂模式，扩展产品族困难，因为要去改AbstractCreator

template            模板模式

builder             建造者模式，与工厂模式的区别是：建造者模式更加关注零件类型和零件装配的顺序

proxy               代理模式

prototype           原型模式

mediator            中介者模式，同事类之间是协作关系

command             命令模式

chainofresponsibility   责任链模式

decorator           装饰模式

strategy            策略模式

adapter             适配器模式

iterator            迭代器模式

composite           组合模式
