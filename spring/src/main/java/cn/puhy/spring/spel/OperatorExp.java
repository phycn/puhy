package cn.puhy.spring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class OperatorExp {

    public static void main(String[] args) {

        ExpressionParser parser = new SpelExpressionParser();

        //关系操作符
        boolean b1 = parser.parseExpression("2 > 5").getValue(Boolean.class);
        System.out.println(b1);

        //字符串比较
        boolean b2 = parser.parseExpression("\"black\" < \"block\"").getValue(Boolean.class);
        System.out.println(b2);

        //instanceof运算符
        boolean b3 = parser.parseExpression("'phy' instanceof T(String)").getValue(Boolean.class);
        System.out.println(b3);

        //正则表达式运算
        boolean b4 = parser.parseExpression("'5.00' matches '^d+$'").getValue(Boolean.class);
        System.out.println(b4);

        //逻辑操作符
        //and与&&相同 or与||相同
        boolean b5 = parser.parseExpression("true and false").getValue(Boolean.class);
        System.out.println(b5);

        //算术操作符
        Integer b6 = parser.parseExpression("2 * 3").getValue(Integer.class);
        System.out.println(b6);

        User user = new User();
        EvaluationContext context = new StandardEvaluationContext(user);

        //安全导航操作符，list为空也不会报空指针异常
        String b7 = parser.parseExpression("list?.get(0)").getValue(context, String.class);
        System.out.println(b7);

        //三元操作符
        String b8 = parser.parseExpression("27 > 28 ? '🙄': '😆'").getValue(context, String.class);
        System.out.println(b8);

        //Elvis操作符，格式<var>?:<value> var为空时取value的值，否则取自身的值
        user.setName("🤡🤠😏");
        String b9 = parser.parseExpression("name?:'我是空的呢'").getValue(context, String.class);
        System.out.println(b9);

        user.setName(null);
        String b10 = parser.parseExpression("name?:'我是空的呢'").getValue(context, String.class);
        System.out.println(b10);
    }
}
