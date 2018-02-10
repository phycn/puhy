package phy.annotation;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@Documented
@interface Persistent {
	String table();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
@Documented
@interface Id {
	String column();

	String type();

	String generator();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
@Documented
@interface Property {
	String column();

	String type();
}

@Persistent(table = "person_inf")
class Person {

	@Id(column = "person_id", type = "integer", generator = "identity")
	private int id;
	@Property(column = "person_name", type = "String")
	private String name;
	@Property(column = "person_age", type = "integer")
	private int age;

	public Person(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
}

@SupportedSourceVersion(SourceVersion.RELEASE_7)
// 指示注释所支持的最新源版本的注释
@SupportedAnnotationTypes({ "Persistent", "Id", "Proterty" })
// 指定可处理的注释
public class AnnotationProcesserTest extends AbstractProcessor {

	// 循环处理每个需要处理的程序对象
	@Override
    public boolean process(Set<? extends TypeElement> annotations,
                           RoundEnvironment roundEnv) {
		// 定义一个文件输出流，用于生成额外的文件
		PrintStream ps = null;
		try {
			// 遍历每个被@Persistent修饰的class文件
			for (Element t : roundEnv
					.getElementsAnnotatedWith(Persistent.class)) {
				// 获取正在处理的类名
				Name clazzName = t.getSimpleName();
				// 获取类定义前的@Persistent Annotation
				Persistent per = t.getAnnotation(Persistent.class);
				// 创建文件输出流
				ps = new PrintStream(new FileOutputStream(clazzName
						+ ".hbm.xml"));
				// 执行输出
				ps.println("<?xml version=\"1.0\"?>");
				ps.println("<!DOCTYPE hibernate-mapping PUBLIC");
				ps.println("	\"-//Hibernate/Hibernate "
						+ "Mapping DTD 3.0//EN\"");
				ps.println("	\"http://www.hibernate.org/dtd/"
						+ "hibernate-mapping-3.0.dtd\">");
				ps.println("<hibernate-mapping>");
				ps.print("	<class name=\"" + t);
				// 输出per的table()的值
				ps.println("\" table=\"" + per.table() + "\">");
				for (Element f : t.getEnclosedElements()) {
					// 只处理Field上的Annotation
					if (f.getKind() == ElementKind.FIELD) // ①
					{
						// 获取Field定义前的@Id Annotation
						Id id = f.getAnnotation(Id.class); // ②
						// 当@Id Annotation存在时输出<id.../>元素
						if (id != null) {
							ps.println("		<id name=\"" + f.getSimpleName()
									+ "\" column=\"" + id.column()
									+ "\" type=\"" + id.type() + "\">");
							ps.println("		<generator class=\"" + id.generator()
									+ "\"/>");
							ps.println("		</id>");
						}
						// 获取Field定义前的@Property Annotation
						Property p = f.getAnnotation(Property.class); // ③
						// 当@Property Annotation存在时输出<property.../>元素
						if (p != null) {
							ps.println("		<property name=\""
									+ f.getSimpleName() + "\" column=\""
									+ p.column() + "\" type=\"" + p.type()
									+ "\"/>");
						}
					}
				}
				ps.println("	</class>");
				ps.println("</hibernate-mapping>");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return true;
	}

}
