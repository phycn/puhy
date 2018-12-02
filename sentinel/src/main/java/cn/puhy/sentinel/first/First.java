package cn.puhy.sentinel.first;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PUHY
 * 2018-11-29 0:06
 */
public class First {

    /**
     * 定义规则
     */
    private static void initRule() {
        List<FlowRule> rules = new ArrayList<>();
        // 定义资源"phy"每秒最多20个请求
        FlowRule rule = new FlowRule();
        // 资源名
        rule.setResource("phy");
        // 限流阈值类型，是按照 QPS 还是线程数
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 限流阈值
        rule.setCount(20);

        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

    /**
     * 日志在C:\Users\PUHY\logs\csp
     * @param args
     */
    public static void main(String[] args) {
        initRule();
        while (true) {
            Entry entry = null;
            try {
                entry = SphU.entry("phy");
                // 需要控制流量的代码
                System.out.println("hello phy");
                Thread.sleep(49);
            } catch (BlockException e) {
                // 资源访问阻止，被限流或被降级
                // 进行相应的处理
                System.out.println("block!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (entry != null) {
                    entry.exit();
                }
            }
        }
    }
}
