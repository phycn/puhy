package cn.puhy.spring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class MethodExp {

    public static void main(String[] args) {

        User user = new User();

        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        //调用String的substring方法
        String str1 = parser.parseExpression("'puhongyu'.substring(1,4)").getValue(String.class);
        System.out.println(str1);

        //调用方法
        String str2 = parser.parseExpression("info()").getValue(context, String.class);
        System.out.println(str2);
    }
}
