package cn.puhy.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * 监控异常
 *
 * @author puhongyu
 * 2018/8/17 19:55
 */
@BTrace
public class MonitorException {
    @TLS
    static Throwable currentException;

    //@Self为自身
    @OnMethod(
            clazz = "java.lang.Throwable",
            method = "<init>"
    )
    public static void onthrow(@Self Throwable self) {//new Throwable()
        currentException = self;
    }

    @OnMethod(
            clazz = "java.lang.Throwable",
            method = "<init>"
    )
    public static void onthrow1(@Self Throwable self, String s) {//new Throwable(String msg)
        currentException = self;
    }

    @OnMethod(
            clazz = "java.lang.Throwable",
            method = "<init>"
    )
    public static void onthrow1(@Self Throwable self, String s, Throwable cause) {//new Throwable(String msg, Throwable cause)
        currentException = self;
    }

    @OnMethod(
            clazz = "java.lang.Throwable",
            method = "<init>"
    )
    public static void onthrow2(@Self Throwable self, Throwable cause) {//new Throwable(Throwable cause)
        currentException = self;
    }

    @OnMethod(
            clazz = "java.lang.Throwable",
            method = "<init>",
            location = @Location(Kind.RETURN)
    )
    public static void onthrowreturn() {
        if (currentException != null) {
            BTraceUtils.Threads.jstack(currentException);
            BTraceUtils.println("=====================");
            currentException = null;
        }
    }
}
