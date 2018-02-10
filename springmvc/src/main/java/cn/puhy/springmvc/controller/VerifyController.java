package cn.puhy.springmvc.controller;

import cn.puhy.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * @author puhongyu
 * 2018/2/2 19:59
 */

@Controller
@RequestMapping("/verify")
public class VerifyController {

    //@Valid为对入参进行校验，BindingResult为校验结果
    //校验对象和校验结果必须成对出现
    @RequestMapping("/handle1")
    public String handle1(@Valid @RequestBody User user, BindingResult bindingResult) {
        System.out.println(user);
        if(bindingResult.hasErrors()) {
            System.out.println(111);
            //获取所有属性校验错误
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for(FieldError fieldError : errorList) {
                System.out.println(fieldError.toString());
            }
            return "error";
        }
        return "/first/success";
    }
}
