package cn.puhy.datastructure.recursion;

/**
 * 三角数值，第n项为第n-1项加n
 *
 * @author puhongyu
 * 2018/3/3 00:27
 */
public class Triangle {

    /**
     * 获取第n项数值，循环实现
     *
     * @param n
     * @return
     */
    private static int getNumByCycle(int n) {
        int num = 0;
        while (n > 0) {
            num = num + n;
            n--;
        }

        return num;
    }

    /**
     * 获取第n项数值，递归实现
     *
     * @param n
     * @return
     */
    private static int getNumByRecursion(int n) {
        int num = 1;
        if (n > 1) {
            num = getNumByRecursion(n - 1) + n;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(getNumByCycle(5));
        System.out.println(getNumByRecursion(5));
    }
}
