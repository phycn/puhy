package cn.puhy.jarslink;

import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.impl.AbstractModuleRefreshScheduler;
import com.google.common.collect.ImmutableList;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 这个调度器在bean初始化的时候会启动一个调度任务，每分钟刷新一次模块，如果模块的版本号发生变更则会更新模块
 *
 * @author puhongyu
 * 2018/5/3 13:07
 */
public class ModuleRefreshSchedulerImpl extends AbstractModuleRefreshScheduler {
    public List<ModuleConfig> queryModuleConfigs() {
        ModuleConfig moduleConfig = buildAModuleConfig("jarslink-a-1.0.jar", "jarslink-a", "1.0");
        List<ModuleConfig> list = new ArrayList<ModuleConfig>();
        list.add(moduleConfig);
        return list;
    }

    public static ModuleConfig buildAModuleConfig(String filePath, String name, String version) {
        ModuleConfig moduleConfig = new ModuleConfig();
        URL demoModule = Thread.currentThread().getContextClassLoader().getResource(filePath);
        //name全局唯一
        moduleConfig.setName(name);
        //enabled当前模块是否可用，默认可用，卸载模块时可以设置成false
        moduleConfig.setEnabled(true);
        //version模块的版本，如果版本号和之前加载的不一致，框架则会重新加载模块
        moduleConfig.setVersion(version);
        //moduleUrl模块的本地存放地址
        moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
        return moduleConfig;
    }
}
