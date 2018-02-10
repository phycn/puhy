phy.basic
    IntegerValTest-java 7新增的二进制数
    BitOperatorTest-位运算符
    LogicOperatorTest-逻辑运算
    SwitchTest-java 7的Switch分支语句
    TwoDimensionTest-二维数组
    ArraysTest-操作数组的工具类
    ArraysTest2-java 8新增的方法
    GeneralHashFunctionLibrary-哈希算法

phy.oop
    PrimitiveTransferTest-方法的参数传递机制
    VariableParameter-形参个数可变的方法
    RecursiveTest-递归方法
    OverloadTest-方法重载
    SubClassTest-多态
    InstanceofTest-instanceof运算符
    InheritTest-继承
    CompositeTest-组合实现复用
    StaticBlock-静态初始化块
    SingletonTest-单例类
    FinalMethodTest-final方法
    ImmutableClassTest-不可变类
    AbstractTest-抽象类
    Outer-非静态内部类
    EnumTest-枚举类
    ParmEnum-带参数的构造器的枚举类
    InterfaceEnum-实现接口的枚举类

    LambdaTest-java 8的Lambda表达式
    LambdaDemo1 Lambda
    LambdaReferenceTest-Lambda表达式的方法引用和构造器引用
    GenericLambda   泛型中的方法引用

phy.oop.factory-简单工厂模式(面向接口编程)

phy.oop.command-命令模式

phy.system-与运行环境交互
    ScannerTest-获取键盘输入
    SystemTest-System类，代表当前运行平台
    RuntimeTest-java程序运行时环境
    CloneTest-Object类的克隆方法
    ObjectsTest-java 7新增的Objects类
    RandomTest-生成随机数
    BigDecimalTest-精确浮点数运算
    CalendarTest-日历
    TimeZoneTest-时区
    RgexTest-正则表达式
    LocalTest-国际化
    SimpleDateFormatTest-格式化日期

phy.collection-java集合
    CollectionTest-Collection接口
    IteratorTest-遍历集合
    HashSetTest-HashSet
    LinkedHashSetTest-LinkedHashSet
    TreeSetTest-TreeSet
    ListTest-List
    ListIteratorTest-ListIterator
    PriorityQueueTest-队列实现类
    ArrayDequeTest-双端队列
    LinkedListTest-LinkedList
    HashMapTest-HashMap
    LinkedHashMapTest-LinkedHashMap
    PropertiesTest-读写属性文件
    TreeMapTest-TreeMap
    WeakHashMapTest-弱引用Map
    IdentityHashMapTest-IdentityHashMap
    CollectionsTest-操作集合的工具类
    SynchronizedTest-同步控制
    UnmodifiableTest-不可变集合
    IteratorMapTest-遍历Map
    
phy.generic-java泛型
	GenericTest-泛型
	Apple-类型形参 
	A1-从泛型类派生子类
	GenericMethodTest-泛型方法
	GenericConstructorTest-泛型构造器   
	ErasureTest-类型擦除
	
phy.exception-异常
    MultiExceptionTest-java7的多异常捕捉
    AutoCloseTest-java7的自动关闭资源的try语句
    StackTraceTest-分析堆栈跟踪信息
    
phy.jdbc
	JdbcTest-jdbc
	PreparedStatementTest-预编译执行sql
	ResultSetTest-结果集
	RowSetFactoryTest-java7的RowSetFactory
	CachedRowSetTest-离线RowSet
	CachedRowSetPageTest-离线RowSet的分页查询
	BatchTest-批量更新  

phy.annotation-注释
    OverrideTest-限定重写父类方法
    DeprecatedTest-标记已过时
    SupressWarningTest-抑制编译器警告
    RetentionTest-@Retention
    TargetTest-@target
    InheritedTest-@Inherited
    CustomAnnotationTest-自定义Annotation
    AnnotationProcesserTest-编译时处理Annotation

phy.io
    FileInputStreamTest-文件字节输入流
    FileReaderTest-文件字符输入流
    FileOutputStreamTest-文件字节输出流
    FileWriterTest-文件字符输出流
    BufferedReaderTest-缓冲流
    PushbackTest-推回输入流
    RedirectOut-重定向输出，输出到文件
    ReadFromProcess-读取其他进程数据
    WriteToProcess-向其他进程输入数据
    RandomAccessFileTest-任意访问文件
    InsertContent-向指定文件的指定位置插入内容

phy.io.serial-对象序列化
    Person-需要序列化的对象
    WriteObject-将对象写入磁盘
    ReadObject-读取对象

phy.io.nio-新IO
    BufferTest-新IO核心对象
    FileChannelTest-新文件Channel
    CharsetTest-字符集
    FileLockTest-文件锁
    PathTest-java 7的NIO2
    FilesTest-java 7的文件类
    FileVisitorTest-java 7 遍历文件和目录
    WatchServiceTest-java 7监控文件变化
    AttributeViewTest-访问文件属性

phy.multithreading-多线程
    ThreadTest-继承Thread的线程类
    RunnableTest-实现Runnable接口的线程类
    ThirdThread-实现Callable接口的线程类
    JoinThread-join线程
    YieldTest-线程让步
    BlockingQueueTest-阻塞队列控制线程通信
    ThreadGroupTest-线程组
    ExHandler-线程的异常处理
    ThreadPool-线程池
    ForkJoinPoolTest-java 7的线程池，充分利用多核CPU（RecursiveAction无返回值的任务）
    RecursiveTaskTest-java 7 有返回值的任务

phy.multithreading.synchronizedCode-同步代码块

phy.multithreading.synchronizedMethod-同步方法

phy.multithreading.lock-同步锁

phy.multithreading.communication-传统的线程通信

phy.multithreading.communication.condition-使用condition控制线程通信(使用Lock对象同步时用到的)

phy.net
    InetAddressTest-IP地址
    URLTest-编码解码

phy.net.URLConnection-多线程下载

phy.net.socket-socket通信
    Server-简单服务端
    Client-简单客户端

    ClientMulti-多线程客户端
    ServerMulti-多线程服务端
    ClientMultiThread-客户端线程类
    ServerMultiThread-服务端线程类

    HalfCloseServer-半关闭Socket的服务端
    HalfCloseClient-半关闭Socket的客户端

phy.reflection
    BootstrapTest-根类加载器
    ClassLoaderPropTest-类加载器
    CustomizeClassLoaderTest-自定义类加载器
    URLClassLoaderTest-URLClassLoader
    ClassTest-Class对象
    ObjectPoolFactoryTest-使用反射创建对象
    ExtendedObjectPoolFactoryTest-使用反射调用方法
    FieldTest-访问类的属性值，包括private属性
    ProxyTest-动态代理

phy.reflection.dynamicAgency-动态代理和AOP

phy.jdk8
	OptionalTest-Optional类
	StreamTest      流
	MapStreamTest   映射流
	Jdk8InterfaceTest   接口静态方法和默认方法