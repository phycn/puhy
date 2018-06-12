package cn.puhy.shardingjdbc.rawjdbc;

import com.google.common.collect.Range;
import io.shardingjdbc.core.api.algorithm.sharding.RangeShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.RangeShardingAlgorithm;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 范围分片算法
 *
 * @author puhongyu
 * 2018/6/10 17:29
 */
public class RangeAlgorithm implements RangeShardingAlgorithm<Integer> {

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Integer> rangeShardingValue) {
        Set<String> set = new HashSet<>();
        Range<Integer> range = rangeShardingValue.getValueRange();
        for (int i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
            for (String table : collection) {
                if (table.endsWith(i % 2 + "")) {
                    set.add(table);
                }
            }
        }
        return set;
    }
}
