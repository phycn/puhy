package test;

import cn.puhy.springmvc.domain.User;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class XmlJsonControllerTest {

    //发送XML报文
    @Test
    public void testXmlHandle1() {
        RestTemplate restTemplate = buildRestTemplate();

        User user = new User();
        user.setAge(99);
        user.setName("隔壁老王");
        user.setPassword("12345678");

        HttpHeaders headers = new HttpHeaders();
        //指定报文体信息
        headers.setContentType(MediaType.valueOf("application/xml;UTF-8"));
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

        HttpEntity<User> httpEntity = new HttpEntity<>(user, headers);
        ResponseEntity<User> responseEntity = restTemplate.exchange("http://localhost:8080/springmvc/xml/handle1",
                HttpMethod.POST, httpEntity, User.class);
        System.out.println("收到的消息：" + responseEntity.getBody());
    }

    //发送JSON报文
    @Test
    public void testJsonHandle1() {
        RestTemplate restTemplate = buildRestTemplate();

        User user = new User();
        user.setAge(99);
        user.setName("隔壁老王");
        user.setPassword("12345678");

        HttpHeaders headers = new HttpHeaders();
        //指定报文体信息
        headers.setContentType(MediaType.valueOf("application/json;UTF-8"));
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<User> httpEntity = new HttpEntity<>(user, headers);
        ResponseEntity<User> responseEntity = restTemplate.exchange("http://localhost:8080/springmvc/xml/handle1",
                HttpMethod.POST, httpEntity, User.class);
        System.out.println("收到的消息：" + responseEntity.getBody());
    }

    private RestTemplate buildRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        //①创建MarshallingHttpMessageConverter处理XML
        XStreamMarshaller xmlMarshaller = new XStreamMarshaller();
        xmlMarshaller.setStreamDriver(new StaxDriver());
        xmlMarshaller.setAnnotatedClasses(new Class[]{User.class});

        MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();
        xmlConverter.setMarshaller(xmlMarshaller);
        xmlConverter.setUnmarshaller(xmlMarshaller);
        restTemplate.getMessageConverters().add(xmlConverter);


        //②创建MappingJacksonHttpMessageConverter处理JSON
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        restTemplate.getMessageConverters().add(jsonConverter);
        return restTemplate;
    }
}
