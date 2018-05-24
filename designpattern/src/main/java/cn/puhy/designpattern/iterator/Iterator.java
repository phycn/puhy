package cn.puhy.designpattern.iterator;

/**
 * 抽象迭代器
 *
 * @author puhongyu
 * 2018/5/19 08:38
 */
public interface Iterator {
    //遍历下一个元素
    Object next();

    //是否已遍历到尾部
    boolean hasNext();

    //删除当前指向的元素
    boolean remove();
}
