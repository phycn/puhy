FirstAgent          javaagent代理
FirstEnhance        增强First类，实现跟AOP一样地功能

JavaSssist          使用javassist动态生成类

Monitor             性能监控，实现AOP的环绕增强

DispatcherServletEnhance    servlet插桩

遇到的坑：
1、pom.xml里配置的Boot-Class-Path的jar包，一定要在打成的jar包当前目录里有
2、继承ClassFileTransformer找类的时候，是要用/，例如cn.puhy.servlet.FirstServlet变为 cn/puhy/servlet/FirstServlet


javaagent是在ClassLoader装载之前拦截修改class当中的内容
javaagent 最后展现形式是一个Jar包，有以下特性
1.必须 META-INF/MANIFEST.MF中指定Premain-Class 设定启agent启动类。
2.在启类需写明启动方法 public static void premain(String arg, Instrumentation inst)
3.不可直接运行，只能通过 jvm 参数-javaagent:xxx.jar 附着于其它jvm 进程运行。
