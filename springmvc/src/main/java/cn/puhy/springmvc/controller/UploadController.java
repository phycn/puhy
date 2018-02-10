package cn.puhy.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author puhongyu
 * 2018/2/4 00:33
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping("/uploadPage")
    public String uploadPage() {

        return "uploadPage";
    }

    //上传的文件自动绑定到MultipartFile
    @RequestMapping("/upload")
    public String upload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) throws IOException {

        if(!file.isEmpty()) {
            System.out.println("文件大小：" + file.getSize());
            System.out.println("文件原名：" + file.getOriginalFilename());
            System.out.println("文件类型：" + file.getContentType());

            //将文件保存到目标文件
            file.transferTo(new File("/Users/puhongyu/phy/tmp/" + file.getOriginalFilename()));
        }
        return "/first/success";
    }
}
