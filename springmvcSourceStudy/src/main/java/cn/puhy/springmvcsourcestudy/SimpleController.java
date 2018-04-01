package cn.puhy.springmvcsourcestudy;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author puhongyu
 * 2018/3/26 22:11
 */
public class SimpleController implements Controller {

    public ModelAndView getName(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("userView");
        mv.addObject("name", "puhongyu");
        if("true".equals(request.getParameter("error"))) {
            throw new RuntimeException("呵呵");
        }
        return mv;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return getName(request, response);
    }
}
