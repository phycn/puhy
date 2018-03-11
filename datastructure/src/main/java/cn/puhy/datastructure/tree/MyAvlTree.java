package cn.puhy.datastructure.tree;

import cn.puhy.datastructure.Common;

/**
 * 平衡二叉树
 *
 * @author puhongyu
 * 2018/3/8 21:15
 */
public class MyAvlTree {

    public Node root;

    /**
     * 获取节点高度，空节点高度为-1
     *
     * @param node
     * @return
     */
    public int getHeight(Node node) {
        return node == null ? -1 : node.height;
    }

    /**
     * 左单旋转
     *
     * @param node 最小不平衡子树的根节点
     */
    private Node leftRotate(Node node) {
        Node nextRoot = node.rightChild;
        node.rightChild = nextRoot.leftChild;
        nextRoot.leftChild = node;

        //重新计算高度
        node.height = Math.max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
        nextRoot.height = Math.max(node.height, getHeight(nextRoot.rightChild)) + 1;
        return nextRoot;
    }

    /**
     * 右单旋转
     *
     * @param node 最小不平衡子树的根节点
     */
    private Node rightRotate(Node node) {
        Node nextRoot = node.leftChild;
        node.leftChild = nextRoot.rightChild;
        nextRoot.rightChild = node;

        //重新计算高度
        node.height = Math.max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
        nextRoot.height = Math.max(node.height, getHeight(nextRoot.leftChild)) + 1;
        return nextRoot;
    }

    /**
     * 左右双旋转，先左后右
     *
     * @param node
     * @return
     */
    private Node leftRightRotate(Node node) {
        node.leftChild = leftRotate(node.leftChild);
        return rightRotate(node);
    }

    /**
     * 右左双旋转，先右后左
     *
     * @param node
     * @return
     */
    private Node rightLeftRotate(Node node) {
        node.rightChild = rightRotate(node.rightChild);
        return leftRotate(node);
    }

    /**
     * 插入节点
     *
     * @param value
     */
    public void insert(int value) {
        root = insert(value, root);
    }

    /**
     * 插入节点
     *
     * @param value 插入的值
     * @param node  当前根节点
     * @return 插入值后的根节点
     */
    private Node insert(int value, Node node) {

        if (node == null) {
            node = new Node(value);
        } else if (value < node.data) { //向左子树查找插入位置
            node.leftChild = insert(value, node.leftChild);
            //因为是左边插入，左子树高度一定大于右子树高度，当高度差为2时需要调整
            if (getHeight(node.leftChild) - getHeight(node.rightChild) == 2) {
                //插入的是左子树，需要进行右单旋转
                if (value < node.leftChild.data) {
                    node = rightRotate(node);
                } else {    //插入的是右子树，需要进行左右双旋转
                    node = leftRightRotate(node);
                }
            }
        } else {    //向右子树查找插入位置
            node.rightChild = insert(value, node.rightChild);
            //因为是右边插入，右子树高度一定大于左子树高度，当高度差为2时需要调整
            if (getHeight(node.rightChild) - getHeight(node.leftChild) == 2) {
                //插入的是右子树，需要进行左单旋转
                if (value > node.rightChild.data) {
                    node = leftRotate(node);
                } else {    //插入的是左子树，需要进行右左双旋转
                    node = rightLeftRotate(node);
                }
            }
        }
        //计算节点高度
        node.height = Math.max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
        return node;
    }

    public void delete(int value) {
        root = delete(value, root);
    }

    /**
     * 删除节点
     *
     * @param value 删除的值
     * @param node  当前根节点
     * @return 删除值后的根节点
     */
    private Node delete(int value, Node node) {
        if (node == null) {
            return null;
        }

        //从左子树开始查找需要删除的节点
        if (value < node.data) {
            node.leftChild = delete(value, node.leftChild);
            //检测高度差
            if (getHeight(node.rightChild) - getHeight(node.leftChild) == 2) {
                Node current = node.rightChild;
                //左单旋转
                if (getHeight(current.leftChild) < getHeight(current.rightChild)) {
                    node = leftRotate(node);
                } else {    //右左旋转
                    node = rightLeftRotate(node);
                }
            }
        } else if (value > node.data) { //从右子树开始查找需要删除的节点
            node.rightChild = delete(value, node.rightChild);
            if (getHeight(node.leftChild) - getHeight(node.rightChild) == 2) {
                Node current = node.leftChild;
                if (getHeight(current.leftChild) > getHeight(current.rightChild)) {
                    //右单旋转
                    node = rightRotate(node);
                } else {    //左右旋转
                    node = leftRightRotate(node);
                }
            }
        } else if (node.leftChild != null && node.rightChild != null) { //已找到删除的节点，删除的节点有两个子节点
            //节点的右子树里去找最小的节点，也就是它的后继节点
            node.data = minNode(node.rightChild).data;
            //移除删除节点的后继节点
            node.rightChild = delete(node.data, node.rightChild);
        } else {    ////只有一个子结点或者只是叶子结点的情况
            //返回的是当前树的根节点，切记
            node = (node.leftChild != null) ? node.leftChild : node.rightChild;
        }

        //更新高度
        if (node != null) {
            node.height = Math.max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
        }
        return node;
    }

    /**
     * 查找最小节点
     *
     * @param node
     * @return
     */
    private Node minNode(Node node) {
        if (node == null) {
            return null;
        }
        //如果没有左节点，就表示自身是最小的
        if (node.leftChild == null) {
            return node;
        }

        return minNode(node.leftChild);
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

    public static void main(String[] args) {
        //[35 43 75 67 4 19 29 89 59 38 ]
//        int[] array = Common.generateArray();
        int[] array = {35, 43, 75, 67, 4, 19, 29, 89, 59, 38};
        Common.display(array);

        MyBinaryTree myBinaryTree = new MyBinaryTree();

        MyAvlTree myAvlTree = new MyAvlTree();
        for (int num : array) {
            myAvlTree.insert(num);
        }
        //中序遍历
        myBinaryTree.middleTraversal(myAvlTree.root);
        System.out.println(myAvlTree.root.data);

        System.out.println(myAvlTree.root.height);

        myAvlTree.delete(67);
        System.out.println(myAvlTree.root.rightChild.data);
    }
}
