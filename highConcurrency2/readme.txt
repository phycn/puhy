atomic
    AtomicExample1                  AtomicInteger例子
    AtomicExample2                  AtomicLong例子
    AtomicExample3                  LongAdder例子，JDK8的，比atomic更快
    AtomicExample4                  AtomicReference例子
    AtomicExample5                  AtomicIntegerFieldUpdater例子，原子更新对象的int型字段
    AtomicExample6                  AtomicBoolean例子

sync
    SynchronizedExample1            同步代码块和同步方法
    SynchronizedExample2            静态同步代码块和静态同步方法

publish                             发布对象
    UnsafePublish                   不安全的发布对象
    Escape                          对象逸出，有可能对象还未构造完就被其他线程读取

singleton                           单例
    SingletonExample1               懒汉模式，线程不安全
    SingletonExample2               饿汉模式，线程安全
    SingletonExample3               懒汉模式，线程安全
    SingletonExample4               懒汉模式，双重同步锁，线程不安全
    SingletonExample5               懒汉模式，双重同步锁，线程安全
    SingletonExample6               饿汉模式，线程安全
    SingletonExample7               枚举模式，线程安全

immutable                           不可变对象
    ImmutableExample1               final修饰的map变量里面的值是可以修改的
    ImmutableExample2               不可变的map，JDK实现
    ImmutableExample3               不可变的map，guava实现

threadLocal                         线程封闭
    HttpFilter                      过滤器
    HttpInterceptor                 拦截器
    RequestHolder                   threadLocal
    ThreadLocalController           测试

commonUnsafe                        线程不安全类
    StringExample1                  StringBuilder，线程不安全
    StringExample2                  StringBuffer，线程安全
    DateFormatExample1              SimpleDateFormat，线程不安全
    DateFormatExample2              SimpleDateFormat，线程安全，线程封闭实现
    DateFormatExample3              通过joda-time实现线程安全的DateFormat
    ArrayListExample                ArrayList，线程不安全
    HashMapExample                  HashMap，线程不安全
    HashSetExample                  HashSet，线程不安全

syncContainer                       同步容器
    VectorExample1                  Vector，线程安全
    VectorExample2                  Vector，线程不安全的情况
    HashTableExample                HashTable，线程安全
    CollectionsExample1             线程安全的ArrayList
    CollectionsExample2             线程安全的HashSet
    CollectionsExample3             线程安全的HashMap
    VectorExample3                  foreach和iterator遍历中删除会报错，for循环不会

concurrent                          并发容器
    CopyOnWriteArrayListExample     CopyOnWriteArrayList
    CopyOnWriteArraySetExample      CopyOnWriteArraySet，底层是用CopyOnWriteArrayList实现
    ConcurrentSkipListMapExample    ConcurrentSkipListMap
    ConcurrentSkipListSetExample    ConcurrentSkipListSet
    ConcurrentHashMapExample        ConcurrentHashMap

    ArrayList -> CopyOnWriteArrayList
    HashSet,TreeSet -> CopyOnWriteArraySet,ConcurrentSkipListSet
    HashMap,TreeMap -> ConcurrentHashMap,ConcurrentSkipListMap

aqs                                 同步器
    CountDownLatchExample1          CountDownLatch
    CountDownLatchExample2          等待限时的CountDownLatch
    SemaphoreExample1               Semaphore
    SemaphoreExample2               Semaphore，获取多个许可
    SemaphoreExample3               Semaphore，尝试获取许可
    SemaphoreExample4               Semaphore，在指定时间内尝试获取许可
    CyclicBarrierExample1           CyclicBarrier
    CyclicBarrierExample2           CyclicBarrier，等待限时
    CyclicBarrierExample3           CyclicBarrier，线程可以继续执行后最先运行的方法
    FutureExample                   Future
    FutureTaskExample               FutureTask
    ForkJoinTaskExample             ForkJoin

lock                                ReentrantLock
    LockExample2                    ReentrantLock
    LockExample3                    读写锁
    LockExample4                    JDK8的StampedLock
    LockExample5                    使用StampedLock
    LockExample6                    Condition

threadPool                          线程池
    ThreadPoolExample1              newCachedThreadPool线程池
    ThreadPoolExample2              newFixedThreadPool线程池
    ThreadPoolExample3              newSingleThreadExecutor线程池
    ThreadPoolExample4              newScheduledThreadPool线程池

deadLock                            死锁
    DeadLock                        死锁

cache                               缓存
    GuavaCacheExample1              guava缓存
    GuavaCacheExample2              guava缓存

rateLimiter                         限流
    RateLimiterExample1             RateLimiter令牌桶
    RateLimiterExample2             RateLimiter令牌桶
