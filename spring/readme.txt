cn.puhy.spring.first												spring初体验

cn.puhy.spring.ioc													ioc容器
	ResourceTest													资源访问
	ResourceLoaderTest												资源加载
	BeanFactoryTest													对象工厂
	
cn.puhy.spring.ioc.lifecycle										bean生命周期
	BeanLifeCycleTest												BeanFactory中的bean生命周期
	cn.puhy.spring.ioc.lifecycle.applicationContext				    ApplicationContext中的bean生命周期
	
cn.puhy.spring.inject												注入
	cn.puhy.spring.inject.property									属性注入
	cn.puhy.spring.inject.constructor								构造器注入
	cn.puhy.spring.inject.method									方法注入(原型模式,动态实现)
	
cn.puhy.spring.beanRelation											bean之间的关系
	cn.puhy.spring.beanRelation.inherit								继承
	cn.puhy.spring.beanRelation.dependence							依赖，depends-on设置依赖
	
cn.puhy.spring.factoryBean											自定义工厂类

cn.puhy.spring.annotation											使用注解
	AnnotationBean.java		                                        带有@Component，@Order注解的bean
	AnnotationBean2.java		                                    带有@Service，@Lazy注解的bean
	AnnotationBean3.java		                                    带有@Autowired和@Qualifier注解的bean
	AnnotationBean4.java		                                    注入集合
	AnnotationBean5.java		                                    @Scope，@PostConstruct和@PreDestroy注解
	annotation-context.xml	                                        扫描
	
cn.puhy.spring.javaConfig											使用java类配置bean
	ConfigBean1.java			                                    @Configuration和@Bean注解
	ConfigBean3.java			                                    @Import和@ImportResource
	
cn.puhy.spring.customTag										    扩展自定义标签
	myTag.xsd					                                    自定义XSD
	MyTagDefinitionParser.java	                                    自定义标签解析类
	MyTagNamespaceHandler.java	                                    注册标签解析类
	spring.schemas				                                    配置自定义XSD文档所在的位置
	spring.handlers				                                    配置自定命名空间所对应的解析器
	customTag-context.xml		                                    引用自定义标签
	
cn.puhy.spring.propertyEditor										自定义属性编辑器
	Bean2Editor.java				                                自定义属性编辑器
	propertyEditor-context.xml	                                    注册属性编辑器
	
cn.puhy.spring.outerProperty					                    使用外部属性文件
	outerProperty-context.xml				                        引用外部属性文件
	MyPropertyPlaceholderConfigurer.java		                    自定义属性转换
	
cn.puhy.spring.event			                                    容器事件
	SendEvent.java				                                    事件源
	SendEventListener.java		                                    事件监听器
	Sender						                                    事件广播器
	
cn.puhy.spring.aop.dynamicAgency									JDK动态代理

cn.puhy.spring.aop.cglib											CGLib动态代理
	
cn.puhy.spring.aop.advice										    aop增强
	GreetingBeforeAdvice.java	                                    前置增强
	GreetingAfterAdvice.java		                                后置增强
	GreetingInterceptor.java		                                环绕增强
	GreetingThrowAdvice			                                    异常抛出增强
	MyMonitor.java				                                    引介增强，为目标类创建新的方法和属性
	aop-context.xml				                                    增强类配置
	
cn.puhy.spring.aop.aspect											切面
	MyAdvisor.java				                                    切面
	MyBeforeAdvice.java			                                    增强
	MyDynamicPointcut.java		                                    动态切点
	MyComposablePointcut.java	                                    复合切点
	aspect-context.xml			                                    切面配置
	
cn.puhy.spring.aop.aspectJ											AspectJ切面

cn.puhy.spring.aop.aspectJ.example									简单例子
	MyAspect.java			                                        切面
	
cn.puhy.spring.aop.aspectJ.methodPointcut							方法切点函数
	MethodPointcutAspect.java		                                方法切点函数切面
	
cn.puhy.spring.aop.aspectJ.methodParam								方法入参切点函数
	MethodParamAspect.java			                                方法入参函数切面
	
cn.puhy.spring.aop.aspectJ.targetClass								目标类切点函数
	TargetClassAspect.java			                                目标类函数切面
	
cn.puhy.spring.aop.aspectJ.introducing								引介增强
	IntroducingAspect.java			                                引介增强切面
	ThisFunctionAspect.java			                                this切点函数

cn.puhy.spring.aop.aspectJ.advance                                  AspectJ进阶
    NamePointcut.java                                               命名切点
    AdvanceAspect.java              切点复合运算，环绕增强，访问连接点信息，绑定连接点入参，绑定代理对象，绑定类注解对象，绑定返回值，绑定异常

cn.puhy.spring.aop.aspectJ.xml                                      xml配置切面
    aspectJ-xml.xml                                                 xml方式配置切面

cn.puhy.spring.spel                     动态表达语言
    ScriptTest.java                     调用js
    SpelTest.java                       第一个SpEL例子
    CompilerTest.java                   SpEL编译器
    CollectionExp.java                  数组，集合类型解析
    MethodExp.java                      方法解析
    OperatorExp.java                    操作符解析
    ObjectExp.java                      赋值，类型，构造器，变量，集合过滤，集合转换
    spel.xml                            基于XML配置使用SpEL
    AnnotationSpel.java                 基于注解配置使用SpEL

cn.puhy.spring.transaction              事务管理
    JDBCTransaction.java                JDBC事务支持
    SpringTransactionExample.java       代码方式实现spring事务

cn.puhy.spring.transaction.isolation    隔离级别
    ReadUncommittedExample.java         未提交读，发生了脏读
    ReadcommittedExample.java           已提交读，发生了不可重复读
    ReadRepeatableExample.java          可重复读

cn.puhy.spring.transaction.xmlcfg       XML配置声明式事务
    tx.xml                              xml配置事务

cn.puhy.spring.transaction.annotationcfg    注解配置声明式事务
    SpringTxAnnotationService.java          @Transactional注解
    TxManager1Transaction.java              自定义事务管理器

cn.puhy.spring.transaction.connectreveal        连接泄露
    UserService.java                            通过两种方式获取连接
    JdbcService.java                            模拟多线程

cn.puhy.spring.springjdbc                   Spring JDBC
    UserDao.java                            Spring JDBC增删查改

cn.puhy.spring.cache                        spring cache
    @Cacheable                              先检查是否有缓存，没有再执行方法并放入缓存
    @CachePut                               总是执行方法并放入缓存
    @CacheEvict                             移除缓存
    @Caching                                组注解，可包含多个@Cacheable，@CachePut
    @CacheConfig                            类级别缓存





	