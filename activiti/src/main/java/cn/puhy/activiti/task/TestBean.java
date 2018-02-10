package cn.puhy.activiti.task;

import java.io.Serializable;

public class TestBean implements Serializable {

    private String a;

    public TestBean(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }
}
