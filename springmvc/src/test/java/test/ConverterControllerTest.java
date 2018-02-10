package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class ConverterControllerTest {

    private RestTemplate restTemplate;

    @Before
    public void init() {
        restTemplate = new RestTemplate();
    }

    @Test
    public void testHandle1() {

        //模拟form数据
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("name", "puhy");
        form.add("password", "123456");
        form.add("age", "28");

        //第一个参数为URL，第二个参数为报文体数据
        restTemplate.postForLocation("http://localhost:8080/springmvc/converter/handle1", form);
    }

    @Test
    public void testHandle2() throws IOException {

        //接收@ResponseBody的数据
        byte[] data = restTemplate.postForObject("http://localhost:8080/springmvc/converter/handle2/12",
                null, byte[].class);
        Resource outFile = new FileSystemResource("/Users/puhongyu/phy/tmp/naturo.jpg");
        FileCopyUtils.copy(data, outFile.getFile());
    }

    @Test
    public void testHandle3() {

        //模拟form数据
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("name", "puhy");
        form.add("password", "123456");
        form.add("age", "28");

        //第一个参数为URL，第二个参数为报文体数据
        restTemplate.postForLocation("http://localhost:8080/springmvc/converter/handle3", form);
    }

    @Test
    public void testHandle4() throws IOException {

        //接收@ResponseBody的数据
        byte[] data = restTemplate.postForObject("http://localhost:8080/springmvc/converter/handle4/1",
                null, byte[].class);
        Resource outFile = new FileSystemResource("/Users/puhongyu/phy/tmp/naturo.jpg");
        FileCopyUtils.copy(data, outFile.getFile());
    }
}
