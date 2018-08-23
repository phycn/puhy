package cn.puhy.springbootstarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author puhongyu
 * 2018/8/22 23:43
 */
//prefix为配置文件中的前缀
@ConfigurationProperties(prefix = "phy")
public class PhyProperties {

    //name属性，默认值为puhongyu
    private String name = "puhongyu";
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
