package cn.puhy.spring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionExp {

    public static void main(String[] args) {

        User user = new User();
        List<String> userlist = new ArrayList<>();
        userlist.add("11");
        userlist.add("22");
        user.setList(userlist);

        Map<String, String> usermap = new HashMap();
        usermap.put("哈哈", "😆");
        user.setMap(usermap);

        ExpressionParser parser = new SpelExpressionParser();
        //将对象存储到EvaluationContext中
        EvaluationContext context = new StandardEvaluationContext(user);

        //数组表达式解析
        int[] array1 = (int[]) parser.parseExpression("new int[]{2,3,4,5}").getValue(context);
        System.out.println(array1.length);

        //List表达式解析
        List list = (List) parser.parseExpression("{1,2,3,4,5}").getValue(context);
        System.out.println(list.get(3));

        //Map表达式解析
        Map map = (Map) parser.parseExpression("{name:'puhy', age:27}").getValue();
        System.out.println(map.get("name") + " " + map.get("age"));

        //从User对象中的List中取值
        String str1 = (String) parser.parseExpression("list[1]").getValue(context);
        System.out.println(str1);

        //从User对象中的Map中取值
        String str2 = (String) parser.parseExpression("map['哈哈']").getValue(context);
        System.out.println(str2);
    }
}
