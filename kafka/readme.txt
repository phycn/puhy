Topic                       主题管理
Consumer|MsgConsumer        消费者
Producer|MsgProducer        生产者
MyPartitioner               自定义分区器，跟shardingt-jdbc分库差不多，实例化KafkaProducer时配置
MySerializer                自定义序列化类，实例化KafkaProducer时配置
MyDeSerializer              自定义反序列化类，实例化KafkaConsumer时配置

cn.puhy.kafka.spring                整合spring
    SpringConsumer                  消费者
    SpringProducer                  生产者
    SpringKafkaConsumerListener     消费监听器
    SpringKafkaProducerListener     生产监听器

cn.puhy.kafka.stream                流式处理
    FirstStream                     快速入门
    KStreamJoin                     KStream连接操作
    KTableJoin                      KTable连接操作
    StreamConsumer                  消费查看效果
    Conversion                      变换操作，过滤，分组，映射，有坑要注意
    StreamLongConsumer              消费VALUE是Long的数据

