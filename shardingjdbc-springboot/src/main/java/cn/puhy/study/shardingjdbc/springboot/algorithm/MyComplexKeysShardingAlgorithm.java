package cn.puhy.study.shardingjdbc.springboot.algorithm;

import io.shardingsphere.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.api.algorithm.sharding.complex.ComplexKeysShardingAlgorithm;

import java.util.Collection;

public class MyComplexKeysShardingAlgorithm implements ComplexKeysShardingAlgorithm {
    @Override
    public Collection<String> doSharding(Collection<String> collection, Collection<ShardingValue> collection1) {
        return null;
    }
}
