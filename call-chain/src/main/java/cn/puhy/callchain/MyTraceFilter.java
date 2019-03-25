package cn.puhy.callchain;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;

/**
 * @author puhongyu
 * 2019-03-25 23:05
 */
@Activate(group = {Constants.CONSUMER, Constants.PROVIDER} , order = -1000)
public class MyTraceFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String traceId = TraceContext.getTraceId();
        RpcContext.getContext().setAttachment("traceId", traceId);
        System.out.println("filter里的traceId: " + traceId);
        return invoker.invoke(invocation);
    }
}
