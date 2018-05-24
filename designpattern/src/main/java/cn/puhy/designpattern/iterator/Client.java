package cn.puhy.designpattern.iterator;

/**
 * @author puhongyu
 * 2018/5/19 08:53
 */
public class Client {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add(1);
        aggregate.add(2);
        aggregate.add(5);

        Iterator iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
