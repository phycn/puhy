package cn.puhy.designpattern.iterator;

import java.util.LinkedList;
import java.util.List;

/**
 * 具体容器
 *
 * @author puhongyu
 * 2018/5/19 08:46
 */
public class ConcreteAggregate implements Aggregate {

    private List<Object> list = new LinkedList<>();

    @Override
    public void add(Object object) {
        list.add(object);
    }

    @Override
    public void remove(Object object) {

    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(list);
    }
}
