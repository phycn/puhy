package cn.puhy.study.shardingjdbc.springboot.dao.model;

/**
 * @author puhongyu
 * 2018/6/10 15:01
 */
public class User {

    private int id;
    private String name;
    private String mobile;
    private String openid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", openid='" + openid + '\'' +
                '}';
    }
}
