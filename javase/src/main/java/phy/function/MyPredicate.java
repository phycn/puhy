package phy.function;

import java.util.function.Predicate;

/**
 * Predicate<T> 断言
 *
 * @author puhongyu
 * 2018/10/10 17:20
 */
public class MyPredicate {
    public static void main(String[] args) {
        Predicate<String> predicate = str -> str.startsWith("phy");
        System.out.println(predicate.test("phy2533"));
        // and相当于&&
        System.out.println(predicate.and(str -> str.endsWith("2533")).test("phy25331"));
        // or相当于||
        System.out.println(predicate.or(str -> str.endsWith("2533")).test("phy25331"));
    }
}
