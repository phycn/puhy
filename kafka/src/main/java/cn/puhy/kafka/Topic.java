package cn.puhy.kafka;

import kafka.admin.AdminUtils;
import kafka.server.ConfigType;
import kafka.utils.ZkUtils;
import org.apache.kafka.common.security.JaasUtils;

import java.util.Properties;

/**
 * 主题管理
 *
 * @author puhongyu
 * 2018/7/6 10:07
 */
public class Topic {

    private static ZkUtils zkUtils = ZkUtils.apply("localhost:2181", 30000, 30000, JaasUtils.isZkSecurityEnabled());

    /**
     * 创建主题
     *
     * @param topic      主题名
     * @param partition  分区数
     * @param replica    副本数
     * @param properties 属性
     */
    public static void createTopic(String topic, int partition, int replica, Properties properties) {
        //主题不存在就创建
        if (!AdminUtils.topicExists(zkUtils, topic)) {
            AdminUtils.createTopic(zkUtils, topic, partition, replica, properties, AdminUtils.createTopic$default$6());
        }
    }

    /**
     * 修改主题级别配置
     *
     * @param topic      主题名
     * @param properties 属性
     */
    public static void modifyTopicConfig(String topic, Properties properties) {
        //获取当前已有配置
        Properties curr = AdminUtils.fetchEntityConfig(zkUtils, ConfigType.Topic(), topic);
        curr.putAll(properties);
        AdminUtils.changeTopicConfig(zkUtils, topic, curr);
    }

    /**
     * 删除主题
     *
     * @param topic 主题名
     */
    public static void deleteTopic(String topic) {
        AdminUtils.deleteTopic(zkUtils, topic);
    }

    public static void main(String[] args) {
        Properties properties = new Properties();
        createTopic("phy1", 2, 1, properties);
    }
}
