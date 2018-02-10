package cn.puhy.spring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class CompilerTest {

    public static void main(String[] args) {

        //创建解析配置
        //SpelCompilerMode.IMMEDIATE为立即启用编辑
        SpelParserConfiguration config = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE,
                CompilerTest.class.getClassLoader());

        //创建解析器
        SpelExpressionParser parser = new SpelExpressionParser(config);

        User user = new User();
        user.setName("😑");
        //创建取值上下文
        EvaluationContext context = new StandardEvaluationContext(user);

        String expression = "getName()";
        //解析表达式
        SpelExpression spelExpression = parser.parseRaw(expression);

        System.out.println(spelExpression.getValue(context));
        System.out.println(spelExpression.getValue(context));
    }
}
