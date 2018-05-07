package cn.puhy.designpattern.chainofresponsibility;

/**
 * @author puhongyu
 * 2018/5/5 21:35
 */
public abstract class Handler {
    private Handler nextHandler;

    //每个处理者都必须对请求做成处理
    public final Response handleMessage(Request request) {
        Response response = null;
        //判断是否为自己的处理级别
        if (this.getHandlerLevel() == request.getLevel()) {
            response = this.handle(request);
        } else {    //不属于自己的处理级别
            if (nextHandler != null) {
                //交给下一个处理者处理
                response = nextHandler.handleMessage(request);
            } else {
                System.out.println("该请求没有任何处理者");
            }
        }
        return response;
    }

    //设置下一个处理者是谁
    public void setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    //每个处理者都有一个处理级别
    protected abstract int getHandlerLevel();

    //每个处理者都必须实现处理任务
    protected abstract Response handle(Request request);
}
