package cn.puhy.designpattern.iterator;

import java.util.List;

/**
 * 具体迭代器
 *
 * @author puhongyu
 * 2018/5/19 08:45
 */
public class ConcreteIterator implements Iterator {

    private List<Object> list;
    private int i = 0;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return list.get(i++);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return i != list.size();
    }

    @Override
    public boolean remove() {
        return false;
    }
}
