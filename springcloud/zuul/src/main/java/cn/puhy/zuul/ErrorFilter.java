package cn.puhy.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @author PUHY
 * 2018-07-23 22:58
 */
public class ErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        System.out.println("eeeeeeeeeeeeeeeeeeeeeeeee");
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        System.out.println("错误：" + throwable.getCause().getMessage());
        ctx.set("error.status_code", 404);
        ctx.set("error.exception", throwable.getCause());
        ctx.set("error.message", "发生了一个错误");
        return null;
    }
}
