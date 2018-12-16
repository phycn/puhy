package cn.puhy.datastructure.common;

/**
 * 求一个整数的平方根
 *
 * @author PUHY
 * 2018-12-16 15:20
 */
public class SquareRoot {

    private static int count = 10;

    private static double getSquareRoot(int num) {
        double min = 0.0;
        double max = (double) num;
        double mid = 0.0;
        for (int i = 0; i < count; i++) {
            mid = (min + max) / 2;
            double square = mid * mid;
            if (square > num) {
                max = mid;
            } else if (square < num) {
                min = mid;
            } else {
                return mid;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(SquareRoot.getSquareRoot(9));
    }
}
