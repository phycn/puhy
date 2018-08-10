package cn.puhy.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author PUHY
 * 2018-07-23 21:03
 */
public class MyFilter extends ZuulFilter {

    //过滤器的类型，有3种，pre|routing|post|error，pre为会在请求被路由之前执行
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    //过滤器的执行顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //过滤器是否要被执行
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器的具体逻辑
    @Override
    public Object run() {
        //获取上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        System.out.println("token: " + token);
        if (StringUtils.isEmpty(token)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
        }
        return null;
    }
}
