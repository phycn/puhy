package cn.puhy.spring.aop.aspectJ.xml;

public class MakeMoneyImpl implements MakeMoney {

    @Override
    public void makeManyMoney() {
        System.out.println("我要赚很多很多的钱");
    }
}
