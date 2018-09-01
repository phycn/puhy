package cn.puhy.spring.transaction.isolation;

import java.sql.*;

/**
 * 未提交读，发生了脏读
 * 脏读：事务B读取到了事务A尚未提交的数据变更
 *
 * @author PUHY
 * 2018-09-01 15:39
 */
public class ReadUncommittedExample {
    static {
        try {
            openConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Connection openConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://192.168.47.129:3306/phy", "root", "root");
    }

    public static void insert(String accountName, String name, int money) {
        try {
            Connection conn = openConnection();
            //关闭自动提交
            conn.setAutoCommit(false);
            PreparedStatement prepare = conn.
                    prepareStatement("insert INTO account (accountName,user,money) VALUES (?,?,?)");
            prepare.setString(1, accountName);
            prepare.setString(2, name);
            prepare.setInt(3, money);
            prepare.executeUpdate();
            System.out.println("执行插入");
            Thread.sleep(3000);
            conn.close();
        } catch (ClassNotFoundException | SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void select(String name, Connection conn) {
        try {

            PreparedStatement prepare = conn.
                    prepareStatement("SELECT * from account where user=?");
            prepare.setString(1, name);
            ResultSet resultSet = prepare.executeQuery();
            System.out.println("执行查询");
            while (resultSet.next()) {
                for (int i = 1; i <= 4; i++) {
                    System.out.print(resultSet.getString(i) + ",");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Thread run(Runnable runnable) {
        Thread thread1 = new Thread(runnable);
        thread1.start();
        return thread1;
    }

    public static void main(String[] args) {
        // 启动插入线程
        Thread t1 = run(() -> insert("1111", "phy", 10000));
        // 启动查询线程
        Thread t2 = run(() -> {
            try {
                Thread.sleep(500);
                Connection conn = openConnection();
                // 将参数升级成 Connection.TRANSACTION_READ_COMMITTED 即可解决脏读的问题
                conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
                select("phy", conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
