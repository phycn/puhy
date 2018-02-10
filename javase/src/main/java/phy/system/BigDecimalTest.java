package phy.system;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalTest {
    
    public static void main(String[] args) {
        
        //输出值不是预期的0.06
        System.out.println(0.05 + 0.01);
        
        BigDecimal f1 = new BigDecimal("-0.04");
        BigDecimal f2 = BigDecimal.valueOf(0.12);
        //不推荐使用double值作为构造器参数，同样为造成精度丢失
        BigDecimal f3 = new BigDecimal(0.03);
        System.out.println(BigDecimal.valueOf(0.12).add(BigDecimal.valueOf(-0.12)));
        System.out.println("减：" + f1.subtract(f2));
        System.out.println("加：" + f1.add(f2));
        System.out.println("乘：" + f1.multiply(f2));
        //直接除需要指定精度
        MathContext mc = new MathContext(2, RoundingMode.HALF_DOWN);
        System.out.println("除：" + f1.divide(f2, mc));
    }
}
