package cn.puhy.study.springsourcestudy;

/**
 * @author puhongyu
 * 2018/3/21 23:44
 */
public class UserService {

    private UserDao userDao;

    public UserService() {
        System.out.println("初始化UserService");
    }

    public void getUser() {
        System.out.println("调用dao");
        userDao.getUser();
    }
}
