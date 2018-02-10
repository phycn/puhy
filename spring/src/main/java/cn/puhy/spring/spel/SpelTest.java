package cn.puhy.spring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpelTest {
    
    public static void main(String[] args) {

        //SpEL解释器
        ExpressionParser parser = new SpelExpressionParser();
        //Expression用来计算表达式的值
        Expression expression = parser.parseExpression("'hello' + ' puhongyu'");
        String message = (String) expression.getValue();
        System.out.println(message);

        User user = new User();
        user.setName("蒲红宇");
        StandardEvaluationContext context = new StandardEvaluationContext(user);
        //获取User的name属性
        String name = (String) parser.parseExpression("name").getValue(context);
        System.out.println(name);

        //设置User的boo属性
        parser.parseExpression("boo").setValue(context, "true");
        System.out.println(user.boo);
    }
}
