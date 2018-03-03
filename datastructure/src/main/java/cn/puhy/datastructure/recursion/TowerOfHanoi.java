package cn.puhy.datastructure.recursion;

/**
 * 汉诺塔，总移动次数为2的n次方减1
 *
 * @author puhongyu
 * 2018/3/3 13:33
 */
public class TowerOfHanoi {

    //移动总次数
    private static int count = 0;

    /**
     * 移动汉诺塔
     *
     * @param num    盘子总数
     * @param from   左柱子
     * @param middle 中柱子
     * @param to     右柱子
     */
    private static void move(int num, String from, String middle, String to) {
        //最上面的盘子
        if (num == 1) {
            System.out.println("盘子1" + "从" + from + "移动到" + to);
        } else {
            //子树移动到中间
            move(num - 1, from, to, middle);
            //最下面的盘子移动到右边
            System.out.println("盘子" + num + "从" + from + "移动到" + to);
            //再把子树移动到最下面的盘子上
            move(num - 1, middle, from, to);
        }
        count++;
    }

    /**
     * 移动总次数
     *
     * @param n 盘子总数
     * @return
     */
    private static int total(int n) {
        if (n == 1) {
            return 1;
        } else {
            //第n项为第n-项的2倍加1
            return 2 * total(n - 1) + 1;
        }
    }

    public static void main(String[] args) {
        move(3, "A", "B", "C");
        System.out.println(total(4));
    }
}
