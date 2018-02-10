简单实例
FirstController.java    控制器
    @PathVariable       将URL中的占位符参数绑定到方法入参
    @RequestParam       绑定请求参数
    @CookieValue        绑定请求中的cookie值
    @RequestHeader      绑定HTTP报文头信息
view/first              视图

ConverterController.java    HttpMessageConverter转换器
    @RequestBody            将请求报文绑定到方法入参
    @ResponseBody           将对象转换为响应信息

XmlJsonController.java          处理XML和JSON
    @RestController             相当于@Controller和@ResponseBody,该控制器的每个方法都会加上@ResponseBody
    XmlJsonControllerTest.java  分别用XML和JSON发送

AsyncController.java            异步无阻塞，web.xml中必须加async-supported标签

ModelController.java            处理模型数据
    @ModelAttribute             1、标注方法入参时将入参添加到模型中
                                2、标注方法时这个方法会先执行
    ModelMap                    Spring MVC会将请求对应的隐含模型对象传递给ModelMap
    @SessionAttributes          多个请求共用模型数据，对于标注了@ModelAttribute的方法入参会添加到隐形模型中

ConversionController.java       数据转换
    @InitBinder                 添加自定义转换器，必须是PropertyEditorSupport的子类
    UserEditor.java             自定义转换器，继承PropertyEditorSupport
    StringToUserConverter.java  实现Converter接口的转换器，需要在XML中配置，目前有问题不知道啥原因
    BindingInitializer.java     全局的自定义转换器，需要装配在RequestMappingHandlerAdapter里

FormatController.java           格式转换
    @DateTimeFormat             将字符串转换为日期
    @NumberFormat               将字符串转换为基本类型

VerifyController.java           数据校验(目前有问题)
    User.java                   校验注解

TagController.java              spring标签（目前有问题）
    tag.jsp                     使用jsp标签

UploadController.java           文件上传，需要配置文件上传解析器

MyWebSocketHandler.java         WebSocket支持，mvc-context.xml中有配置
    ws.jsp                      发送和接收消息

    hehe





