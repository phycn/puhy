package cn.puhy.datastructure.recursion;

/**
 * 普通递归
 *
 * @author puhongyu
 * 2018/3/2 22:56
 */
public class OrdinaryRecursion {

    private static void recursion(int n) {

        //递归一定要有结束条件，不然就是死循环，堆栈溢出
        if (n == 0) {
            return;
        }
        System.out.println(n);
        recursion(n - 1);
    }

    public static void main(String[] args) {
        recursion(10);
    }
}
