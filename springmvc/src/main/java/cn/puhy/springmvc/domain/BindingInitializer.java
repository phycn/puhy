package cn.puhy.springmvc.domain;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * 全局的自定义转换器
 *
 * @author puhongyu
 * 2018/1/30 22:23
 */
public class BindingInitializer implements WebBindingInitializer {
    @Override
    public void initBinder(WebDataBinder binder, WebRequest request) {
        System.out.println("全局自定义转换器");
        binder.registerCustomEditor(User.class, new UserEditor());
    }
}
