package cn.puhy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 同步servlet
 *
 * @author puhongyu
 * 2019-03-07 21:28
 */
public class SyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long start = System.currentTimeMillis();
        doSomeThing(req, resp);
        System.out.println("同步servlet耗时: " + (System.currentTimeMillis() - start));
    }

    private void doSomeThing(HttpServletRequest req, HttpServletResponse resp) {
        try {
            // 模拟耗时操作
            TimeUnit.SECONDS.sleep(5);
            resp.getWriter().append("完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
