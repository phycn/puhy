package phy.oop;

/**
 * 泛型中的方法引用
 */
public class GenericLambda {
    static <A> int myOp(MyFunc<A> myFunc, A[] vals, A v) {
        return myFunc.func(vals, v);
    }

    public static void main(String[] args) {
        Integer[] array = {2, 3, 4, 5, 6, 7, 1, 2, 2, 3};
        //MyArrayOps与MyFunc接口的func方法返回类型一样
        int num = myOp(MyArrayOps::<Integer>count, array, 2);
        System.out.println(num);
    }
}

interface MyFunc<A> {
    int func(A[] vals, A v);
}

class MyArrayOps {
    static <A> int count(A[] vals, A v) {
        int num = 0;
        for (A val : vals) {
            if (v == val) {
                num++;
            }
        }
        return num;
    }
}