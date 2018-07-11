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

