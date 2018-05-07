package cn.puhy.designpattern.chainofresponsibility;

/**
 * @author puhongyu
 * 2018/5/5 21:53
 */
public class ConcreteHandler1 extends Handler {
    protected int getHandlerLevel() {
        return 1;
    }

    protected Response handle(Request request) {
        Response response = new Response();
        response.setData(request.getLevel() + "由ConcreteHandler1处理");
        return response;
    }
}
