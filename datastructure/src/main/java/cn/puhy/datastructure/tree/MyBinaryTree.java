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
     * 插入节点，用中序遍历会是排序的
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
    public Node find(int value) {
        Node current = root;
        while (true) {
            if (current == null) {
                return null;
            }
            if (value < current.data) {
                current = current.leftChild;
            } else if (value > current.data) {
                current = current.rightChild;
            } else {
                return current;
            }
        }
    }

    /**
     * 删除节点
     *
     * @param value
     */
    public void delete(int value) {
        //当前节点
        Node current = root;
        //当前节点父节点
        Node parent = root;
        //是否为左节点
        boolean isLeft = true;
        //先找到需要删除的节点
        while (current.data != value) {
            parent = current;
            if (current.data < value) {
                current = current.rightChild;
                isLeft = false;
            } else {
                current = current.leftChild;
                isLeft = true;
            }

            if (current == null) {
                return;
            }
        }
        //删除的节点是叶子节点
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeft) {
                //需要删除的节点的父节点的左节点设为null，这样就删除了节点
                parent.leftChild = null;
            } else {
                //需要删除的节点的父节点的右节点设为null，这样就删除了节点
                parent.rightChild = null;
            }
            //删除的节点只有右节点
        } else if (current.leftChild == null) {
            //如果删除的节点为根节点，将根节点的右节点设为根节点
            if (current == root) {
                root = current.rightChild;
            } else if (isLeft) {
                //父节点的左节点设为当前节点的右节点
                parent.leftChild = current.rightChild;
            } else {
                //父节点的右节点设为当前节点的右节点
                parent.rightChild = current.rightChild;
            }
            //删除的节点只有左节点
        } else if (current.rightChild == null) {
            ////如果删除的节点为根节点，将根节点的左节点设为根节点
            if (current == root) {
                root = current.leftChild;
            } else if (isLeft) {
                //父节点的左节点设为当前节点的左节点
                parent.leftChild = current.leftChild;
            } else {
                //父节点的右节点设为当前节点的左节点
                parent.rightChild = current.leftChild;
            }
            //删除的节点既有左节点，又有右节点，用后继节点顶替删除的节点
        } else {
            //找到删除节点的后继节点，一直找它右节点的左节点，直到左节点为空
            Node nextNode = current.rightChild;
            Node nextNodeParent = current;
            while (nextNode.leftChild != null) {
                nextNodeParent = nextNode;
                nextNode = nextNode.leftChild;
            }

            //后继节点的左节点设为删除节点的左节点
            nextNode.leftChild = current.leftChild;
            //后继节点的父节点不为删除的节点
            if (nextNodeParent.data != current.data) {
                //后继节点的右节点设为删除节点的右节点
                nextNode.rightChild = current.rightChild;
                //后继节点的左节点为空
                nextNodeParent.leftChild = null;
            }
            //删除的节点为根节点，需要设置新的根节点
            if (current == root) {
                root = nextNode;
            } else if (isLeft) {
                parent.leftChild = nextNode;
            } else {
                parent.rightChild = nextNode;
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

        System.out.println(tree.find(66).data);

//        tree.frontTraversal(root);
        System.out.println("-------------------------");
        tree.middleTraversal(root);
        System.out.println("-------------------------");
//        tree.laterTraversal(root);

        tree.delete(66);
        //这里50为根节点
        tree.delete(50);
        //当前根节点为12
        System.out.println(tree.root.data);
        tree.middleTraversal(tree.root);

        //删除有两个子节点的节点
        tree.delete(23);

        tree.insert(20);
        //删除根节点，有两个子节点
        tree.delete(12);
        System.out.println(tree.root.data);
        tree.middleTraversal(tree.root);

        tree.insert(15);
        tree.insert(11);
        tree.insert(17);
        tree.insert(10);
        tree.insert(13);
        System.out.println("-------------------------");
        tree.middleTraversal(tree.root);
        tree.delete(8);
        System.out.println("-------------------------");
        tree.middleTraversal(tree.root);

        //10
        System.out.println(tree.find(20).leftChild.data);
        //6
        System.out.println(tree.find(10).leftChild.data);
        //15
        System.out.println(tree.find(10).rightChild.data);
        //null
        System.out.println(tree.find(11).leftChild);
    }
}
