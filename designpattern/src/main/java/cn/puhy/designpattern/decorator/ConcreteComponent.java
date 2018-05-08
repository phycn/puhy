package cn.puhy.designpattern.decorator;

/**
 * 具体组件，也就是需要被修饰的
 *
 * @author puhongyu
 * 2018/5/8 06:49
 */
public class ConcreteComponent extends Component {
    @Override
    public void doSomething() {
        System.out.println("do something");
    }
}
