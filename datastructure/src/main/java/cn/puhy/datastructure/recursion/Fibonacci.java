package cn.puhy.datastructure.recursion;

/**
 * 斐波那契数列，第1项为0，第2项为1，第n项为第n-1项加上第n-2项
 *
 * @author puhongyu
 * 2018/3/3 13:07
 */
public class Fibonacci {

    private static int getNum(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return getNum(n - 1) + getNum(n - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(getNum(10));
    }
}
