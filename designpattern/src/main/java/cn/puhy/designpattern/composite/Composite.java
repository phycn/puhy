package cn.puhy.designpattern.composite;

import java.util.LinkedList;
import java.util.List;

/**
 * 树枝组件
 *
 * @author puhongyu
 * 2018/5/24 13:24
 */
public class Composite extends Component {

    private List<Component> list = new LinkedList<>();

    @Override
    public void add(Component component) {
        list.add(component);
    }

    @Override
    public void remove(Component component) {
        list.remove(component);
    }

    @Override
    public List<Component> getChildren() {
        return list;
    }
}
