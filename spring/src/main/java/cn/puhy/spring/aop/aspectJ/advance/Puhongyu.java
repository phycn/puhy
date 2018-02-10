package cn.puhy.spring.aop.aspectJ.advance;

@Chengxuyuan
public class Puhongyu {

    public void studySpring() {
        System.out.println("蒲红宇学习Spring");
    }

    public void studyRedis(int a) {
        System.out.println("蒲红宇学习Redis");
    }

    public void study(String one, String two) {
        System.out.println("蒲红宇学习" + one + "和" + two);
    }

    public void bindJoinPointParam(String param1, int param2) {
        System.out.println("测试绑定连接点入参的");
    }

    public void bindProxyObejct(Integer num) {
        System.out.println("测试绑定代理对象");
    }

    public int getAge() {
        return 27;
    }

    public void bindException() throws Exception {
        throw new Exception("测试绑定异常");
    }

    @Override
    public String toString() {
        return "哈哈哈";
    }
}
