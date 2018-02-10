package cn.puhy.spring.ioc.test;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class ResourceLoaderTest {
	public static void main(String[] args) throws IOException {
		
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		//匹配cn/puhy类路径下的所有文件,没有java文件，都是class文件
		Resource resources[] = resolver.getResources("classpath*:cn/puhy/**/*");
		for(Resource resource : resources) {
			System.out.println(resource.getFilename());
		}
	}
}
