package cn.puhy.designpattern.chainofresponsibility;

/**
 * @author puhongyu
 * 2018/5/5 21:53
 */
public class ConcreteHandler2 extends Handler {
    protected int getHandlerLevel() {
        return 2;
    }

    protected Response handle(Request request) {
        Response response = new Response();
        response.setData(request.getLevel() + "由ConcreteHandler2处理");
        return response;
    }
}
