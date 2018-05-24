package cn.puhy.designpattern.iterator;

/**
 * 抽象容器
 * @author puhongyu
 * 2018/5/19 08:41
 */
public interface Aggregate {
    //增加元素
    void add(Object object);
    //减少元素
    void remove(Object object);
    //由迭代器遍历元素
    Iterator iterator();
}
