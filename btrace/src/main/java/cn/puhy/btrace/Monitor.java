package cn.puhy.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

import java.lang.reflect.Field;

/**
 * 监控运行中的类
 *
 * @author puhongyu
 * 2018/8/16 23:15
 */
@BTrace
public class Monitor {
    //clazz为拦截的类，method为拦截的方法，location为拦截的时候
    //Kind.ENTRY 入口，默认值
    //Kind.RETURN 返回
    //Kind.THROW 异常
    //Kind.LINE 行
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

    //拦截获取返回参数
    @OnMethod(
            clazz = "cn.puhy.btrace.BtraceController",
            method = "returnArg",
            location = @Location(Kind.RETURN)
    )
    public static void returnArg(@ProbeClassName String pcn, @ProbeMethodName String pmn, @Return AnyType result) {
        BTraceUtils.println(pcn + "," + pmn + "," + result);
        BTraceUtils.println();
    }

    //拦截指定某行，某行执行了就能获取到行号
    @OnMethod(
            clazz = "cn.puhy.btrace.BtraceController",
            method = "exception",
            location = @Location(value = Kind.LINE, line = 2)
    )
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, int line) {
        BTraceUtils.println(pcn + "," + pmn + "," + line);
        BTraceUtils.println();
    }

    //拦截复合对象，执行脚本时要加-cp User类的路径
    @OnMethod(
            clazz = "cn.puhy.btrace.BtraceController",
            method = "arg2",
            location = @Location(Kind.ENTRY)
    )
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, User user) {
        //获取所有字段
        BTraceUtils.printFields(user);
        //获取指定字段
        Field filed2 = BTraceUtils.field("cn.puhy.btrace.User", "name");
        BTraceUtils.println(BTraceUtils.get(filed2, user));
        BTraceUtils.println(pcn + "," + pmn);
        BTraceUtils.println();
    }
}
