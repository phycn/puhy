package cn.puhy.javaagent;

import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * First类增强，使用javassist
 *
 * @author puhongyu
 * 2018/6/14 21:38
 */
public class FirstEnhance implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        try {
            if ("cn/puhy/javaagent/First".equals(className)) {
                System.out.println(Thread.currentThread().getContextClassLoader());
                System.out.println(loader);
                ClassPool pool = ClassPool.getDefault();
                pool.insertClassPath(new LoaderClassPath(loader));
                CtClass ctClass = pool.get("cn.puhy.javaagent.First");
                CtMethod ctMethod = ctClass.getDeclaredMethod("hello");
                ctMethod.insertBefore("System.out.println(\"前置增强呢...\");");
                ctMethod.insertAfter("System.out.println(\"后置增强呢...\");");
                System.out.println("121212");
                return ctClass.toBytecode();
            }
        } catch (NotFoundException | CannotCompileException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
