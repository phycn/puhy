package cn.puhy.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 异步Servlet
 *
 * @author puhongyu
 * 2019-03-07 21:54
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/async"})
public class AsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long start = System.currentTimeMillis();
        // 开启异步
        AsyncContext asyncContext = req.startAsync();
        // 执行业务代码
        CompletableFuture.runAsync(() -> doSomeThing(asyncContext,
                asyncContext.getRequest(), asyncContext.getResponse()));
        System.out.println("异步servlet耗时: " + (System.currentTimeMillis() - start));
    }

    private void doSomeThing(AsyncContext asyncContext,
                             ServletRequest servletRequest, ServletResponse servletResponse) {

        // 模拟耗时操作
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //
        try {
            servletResponse.getWriter().append("done");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 业务代码处理完毕, 通知结束
        asyncContext.complete();
    }
}
