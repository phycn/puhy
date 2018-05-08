package cn.puhy.designpattern.decorator;

/**
 * 抽象装饰器
 *
 * @author puhongyu
 * 2018/5/8 06:51
 */
public abstract class Decorator extends Component {
    private Component component;
    //通过构造函数传递需要修饰的组件
    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void doSomething() {
        component.doSomething();
    }
}
