package cn.puhy.shardingjdbc.rawjdbc;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * 分库算法
 *
 * @author puhongyu
 * 2018/6/10 11:28
 */
public class ShardingDatabaseAlgorithm implements PreciseShardingAlgorithm<Integer> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Integer> preciseShardingValue) {
        for (String str : collection) {
            if (str.endsWith(preciseShardingValue.getValue() % 2 + "")) {
                return str;
            }
        }
        return null;
    }
}
