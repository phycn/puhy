package cn.puhy.datastructure.recursion;

import java.util.ArrayList;

/**
 * 将一个整数分解为多个整数
 *
 * @author PUHY
 * 2018-12-21 23:38
 */
public class ResolveInteger {

    public static void resolve(int total, ArrayList<Integer> result) {

        if (total == 1) {
            if (!result.contains(1)) {
                result.add(1);
            }
            System.out.println(result);
        } else {
            for (int i = 1; i <= total; i++) {
                if (i == 1 && result.contains(1)) {
                    continue;
                }
                if (total % i == 0) {
                    ArrayList<Integer> newList = (ArrayList<Integer>) result.clone();
                    newList.add(i);
                    resolve(total / i, newList);
                }
            }
        }
    }

    public static void main(String[] args) {
        resolve(4, new ArrayList<>());
    }
}
