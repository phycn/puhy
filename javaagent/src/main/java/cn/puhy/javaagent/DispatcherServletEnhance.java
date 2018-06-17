package cn.puhy.javaagent;

import javassist.*;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

/**
 * @author puhongyu
 * 2018/6/15 06:54
 */
public class DispatcherServletEnhance implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        try {
            if ("cn/puhy/servlet/FirstServlet".equals(className)) {
                ClassPool pool = ClassPool.getDefault();
                pool.insertClassPath(new LoaderClassPath(loader));
                CtClass ctClass = pool.get("cn.puhy.servlet.FirstServlet");
                CtClass[] params = new CtClass[]{
                        pool.get("javax.servlet.http.HttpServletRequest"),
                        pool.get("javax.servlet.http.HttpServletResponse")
                };
                CtMethod method = ctClass.getDeclaredMethod("service", params);
                method.insertBefore("cn.puhy.javaagent.DispatcherServletCollect.begin($args);");
                pool.get("cn.puhy.javaagent.DispatcherServletCollect").toClass(loader, null);
                return ctClass.toBytecode();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
