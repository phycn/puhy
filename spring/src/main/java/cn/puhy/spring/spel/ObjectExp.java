package cn.puhy.spring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectExp {

    public static void main(String[] args) {

        ExpressionParser parser = new SpelExpressionParser();
        User user = new User();
        EvaluationContext context = new StandardEvaluationContext(user);

        //通过setValue赋值
        parser.parseExpression("name").setValue(context, "是蒲红宇呢");
        System.out.println(user.getName());

        //通过getValue赋值
        parser.parseExpression("name = '怎么又是蒲红宇'").getValue(context);
        System.out.println(user.getName());

        //通过T操作符加载类
        Class stringClass = parser.parseExpression("T(java.lang.String)").getValue(Class.class);
        System.out.println(stringClass.getName());

        //通过T操作符调用类的静态方法
        String str1 = parser.parseExpression("T(cn.puhy.spring.spel.User).hehe()").getValue(String.class);
        System.out.println(str1);

        //构造器
        User user1 = parser.parseExpression("new cn.puhy.spring.spel.User(27)").getValue(User.class);
        System.out.println(user1.getAge());

        //设置变量
        context.setVariable("boo", true);
        //取变量值，#变量名
        parser.parseExpression("boo=#boo").getValue(context);
        System.out.println(user.boo);

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        context.setVariable("list", intList);

        //List集合过滤，?[#this>3]为过滤条件，取intList中值大于3的
        List<Integer> intlist2 = (List<Integer>) parser.parseExpression("#list.?[#this>3]").getValue(context);
        System.out.println(intlist2);

        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("1", 1);
        myMap.put("2", 2);
        myMap.put("3", 3);
        myMap.put("4", 4);
        myMap.put("5", 5);
        context.setVariable("myMap", myMap);

        //Map集合过滤，?[value>2]为过滤条件，取value大于2的
        Map<String, Integer> myMap2 = (Map<String, Integer>) parser.parseExpression("#myMap.?[value>2]").getValue(context);
        System.out.println(myMap2);

        //集合转换，![#this + 100]，取得的值加100，得到一个新集合
        List<Integer> intList3 = (List<Integer>) parser.parseExpression("#list.![#this + 100]").getValue(context);
        System.out.println(intList3);
    }
}
