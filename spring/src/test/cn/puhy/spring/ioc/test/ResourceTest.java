package cn.puhy.spring.ioc.test;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.core.io.support.EncodedResource;

public class ResourceTest {
	public static void main(String[] args) throws IOException {
		
		String filePath = "/Users/puhongyu/phy/workspace/puhy/spring/src/main/java/cn/puhy/spring/ioc/ResourceExample.java";
		//使用绝对路径访问资源，WritableResource为可写资源接口，有两个实现类，即FileSystemResource和Pathsource
		WritableResource r1 = new PathResource(filePath);
		//指定编码访问
		EncodedResource er = new EncodedResource(r1, "UTF-8");
		//使用类路径访问资源
		Resource r2 = new ClassPathResource("cn/puhy/spring/first/smart-context.xml");
		r2.getURL();
		InputStream is =  r2.getInputStream();
		
		int hasRead = 0;
		byte[] buff = new byte[1024];
        //循环读取，将读取到的放入buff数组里
        while((hasRead = is.read(buff)) > 0) {
            //将字节数组转换成字符串输出
            System.out.print(new String(buff, 0, hasRead));
        }
        is.close();
		
	}
}
