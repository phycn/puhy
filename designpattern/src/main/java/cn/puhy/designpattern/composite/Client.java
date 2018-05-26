package cn.puhy.designpattern.composite;

/**
 * @author puhongyu
 * 2018/5/24 13:27
 */
public class Client {
    public static void main(String[] args) {
        //根节点
        Component root = new Composite();
        //树枝节点
        Component branch = new Composite();
        //叶子节点
        Component leaf1 = new Leaf();
        Component leaf2 = new Leaf();
        branch.add(leaf1);
        branch.add(leaf2);

        root.add(branch);
        System.out.println(root.getChildren().size());
    }
}
