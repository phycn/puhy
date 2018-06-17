package cn.puhy.javaagent;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;

public class Monitor {
    public static void main(String[] args) throws NotFoundException, CannotCompileException {
        ClassPool pool = new ClassPool(true);
        String targetClassName = "cn.puhy.javaagent.StringUtil";
//        String targetClassName = StringUtil.class.getName();
        CtClass targetClass = pool.get(targetClassName);
        CtMethod method = targetClass.getDeclaredMethod("addString");
        CtMethod agentMethod = CtNewMethod.copy(method, method.getName() + "$agent", targetClass, null);
        targetClass.addMethod(agentMethod);
        //$$代表所有方法参数
        //$r代表方法返回值的类型，主要用在类型的转型上
        String src = "{"
                + "long begin = System.nanoTime();"
                + "Object result=" + method.getName() + "$agent($$);"
                + "long end = System.nanoTime();"
                + "System.out.println(end-begin);"
                + "return ($r)result;"
                + "}";
        method.setBody(src);
        // 载入至当前ClassLoader
        targetClass.toClass();
//		BitStringUtil util=new BitStringUtil();
        StringUtil util = new StringUtil();
        util.addString(1000);
    }
}
