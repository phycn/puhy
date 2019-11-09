package test;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public List<Bean> getBeans() {
        return beans;
    }

    public void setBeans(List<Bean> beans) {
        this.beans = beans;
    }

    private List<Bean> beans;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> list1 = new ArrayList<>();
        list1 = list.subList(0, 1);
        System.out.println(list);
    }
}

class Bean {
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "num=" + num +
                '}';
    }
}
