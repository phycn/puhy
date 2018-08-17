package cn.puhy.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * 监控运行中的方法参数
 *
 * @author puhongyu
 * 2018/8/16 23:15
 */
@BTrace
public class Monitor {
    //clazz为拦截的类，method为拦截的方法，location为拦截的时候，ENTRY为进入方法的时候
    @OnMethod(
            clazz = "cn.puhy.btrace.BtraceController",
            method = "hello",
            location = @Location(Kind.ENTRY)
    )
    //@ProbeClassName 拦截的类名
    //@ProbeMethodName 拦截的方法名
    //AnyType[] 方法参数
    public static void arg(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] args) {
        BTraceUtils.printArray(args);
        BTraceUtils.println(pcn + "," + pmn);
        BTraceUtils.println();
    }

    //拦截构造器
    @OnMethod(
            clazz = "cn.puhy.btrace.BtraceController",
            method = "<init>"
    )
    public static void constructor(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] args) {
        BTraceUtils.println(pcn + "," + pmn);
        BTraceUtils.printArray(args);
        BTraceUtils.println();
    }
}
