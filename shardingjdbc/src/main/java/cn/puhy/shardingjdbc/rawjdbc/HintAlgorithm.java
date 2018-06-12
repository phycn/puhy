package cn.puhy.shardingjdbc.rawjdbc;

import io.shardingjdbc.core.api.algorithm.sharding.ShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.hint.HintShardingAlgorithm;

import java.util.Collection;

/**
 * 非SQL解析的方式分片算法
 *
 * @author puhongyu
 * 2018/6/11 22:27
 */
public class HintAlgorithm implements HintShardingAlgorithm {
    @Override
    public Collection<String> doSharding(Collection<String> collection, ShardingValue shardingValue) {
        return null;
    }
}
