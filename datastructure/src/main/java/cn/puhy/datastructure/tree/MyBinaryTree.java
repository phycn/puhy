package cn.puhy.datastructure.tree;

/**
 * 二叉排序树
 *
 * @author puhongyu
 * 2018/3/5 21:04
 */
public class MyBinaryTree {

    //根节点
    public Node root;

    /**
     * 插入节点
     *
     * @param value
     */
    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
        } else {
            //从根节点开始找
            Node current = root;
            while (true) {
                //小于当前节点就插在当前节点的左子树
                if (value < current.data) {
                    if (current.leftChild == null) {
                        current.leftChild = node;
                        return;
                    }
                    //继续查找合适位置
                    current = current.leftChild;
                    //大于或等于当前节点就插在当前节点的右子树
                } else {
                    if (current.rightChild == null) {
                        current.rightChild = node;
                        return;
                    }
                    //继续查找合适位置
                    current = current.rightChild;
                }
            }
        }
    }

    /**
     * 查找节点
     *
     * @param value
     * @return
     */
    public boolean find(int value) {
        Node current = root;
        while (true) {
            if (current == null) {
                return false;
            }
            if (value < current.data) {
                current = current.leftChild;
            } else if (value > current.data) {
                current = current.rightChild;
            } else {
                return true;
            }
        }
    }

    /**
     * 前序遍历，先根节点，再左节点，最后右节点
     *
     * @param node 树的根节点
     */
    public void frontTraversal(Node node) {
        if (node != null) {
            System.out.println("前序遍历：" + node.data);
            frontTraversal(node.leftChild);
            frontTraversal(node.rightChild);
        }
    }

    /**
     * 中序遍历，先左节点，再根节点，最后右节点
     *
     * @param node
     */
    public void middleTraversal(Node node) {
        if (node != null) {
            middleTraversal(node.leftChild);
            System.out.println("中序遍历：" + node.data);
            middleTraversal(node.rightChild);
        }
    }

    /**
     * 后序遍历，先左节点，再右节点，最后根节点
     *
     * @param node
     */
    public void laterTraversal(Node node) {
        if (node != null) {
            laterTraversal(node.leftChild);
            laterTraversal(node.rightChild);
            System.out.println("后序遍历：" + node.data);
        }
    }

    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        tree.insert(50);
        tree.insert(12);
        tree.insert(8);
        tree.insert(23);
        tree.insert(6);
        tree.insert(4);
        tree.insert(66);
        tree.insert(21);
        tree.insert(24);

        Node root = tree.root;
        System.out.println(root.data);
        System.out.println(root.leftChild.leftChild.leftChild.data);

        System.out.println(tree.find(66));

        tree.frontTraversal(root);

        tree.middleTraversal(root);

        tree.laterTraversal(root);
    }
}
