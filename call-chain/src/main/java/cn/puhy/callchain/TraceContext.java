package cn.puhy.callchain;

public class TraceContext {
    private final static ThreadLocal<String> traceIdThreadLocal = new ThreadLocal<>();

    public static void addTraceId(String id) {
        traceIdThreadLocal.set(id);
    }

    public static void removeTraceId() {
        traceIdThreadLocal.remove();
    }

    public static String getTraceId() {
        return traceIdThreadLocal.get();
    }
}
