package cn.puhy.dubbo.provider.service;

import cn.puhy.dubbo.api.MergeService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author puhongyu
 * 2018/5/12 11:51
 */
public class MergeServiceImpl2 implements MergeService {
    @Override
    public List<String> mergeResult() {
        List<String> list = new ArrayList<>();
        list.add("MergeServiceImpl2");
        return list;
    }
}
