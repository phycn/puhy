package cn.puhy.javaagent;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.LoaderClassPath;
import javassist.NotFoundException;

/**
 * 使用javassist动态生成一个类
 */
public class JavaSssist {

    public static void main(String[] args) throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException {
        ClassPool pool = new ClassPool(true);
        // 插入类路径，通过类路径去搜索我们要的类
        pool.insertClassPath(new LoaderClassPath(JavaSssist.class
                .getClassLoader()));
        // 构建一个新的CtClass对象
        CtClass targetClass = pool.makeClass("cn.puhy.myJavassist");
        // 实现接口
        targetClass.addInterface(pool.get(IHello.class.getName()));
        //返回类型
        CtClass returnType = pool.get(void.class.getName());
        String mname = "sayHello";
        //方法参数
        CtClass[] parameters = new CtClass[]{pool.get(String.class.getName())};
        CtMethod method = new CtMethod(returnType, mname, parameters, targetClass);


        String src = "{"
                + "System.out.println(\"当前对象：\" + $0);"
                + "System.out.println(\"第一个参数值：\" + $1);"
                + "System.out.println(\"$args表示所有参数的数组：\" + $args[0]);"
//				+ "System.out.println(\"返回值类型：\" + $r);"
//                + "System.out.println(\"方法返回值：\" + $_);"
                + "System.out.println(\"方法参数的类型数组：\" + $sig[0]);"
                + "System.out.println(\"当前类的类型：\" + $class);"
//                + "System.out.println(\"方法递归深度：\" + $cflow(sayHello));"
                + "}";
        method.setBody(src);
        targetClass.addMethod(method);

        Class cla = targetClass.toClass();
        IHello hello = (IHello) cla.newInstance();
        hello.sayHello("蒲红宇");

    }

    public interface IHello {
        void sayHello(String name);
    }
}
