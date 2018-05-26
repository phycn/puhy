package cn.puhy.designpattern.composite;

import java.util.List;

/**
 * 叶子组件
 *
 * @author puhongyu
 * 2018/5/24 13:22
 */
public class Leaf extends Component {
    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Component> getChildren() {
        throw new UnsupportedOperationException();
    }
}
