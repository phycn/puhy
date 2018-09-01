package cn.puhy.spring.transaction.isolation;

import java.sql.*;

/**
 * 已提交读，发生了不可重复读
 *
 * @author PUHY
 * 2018-09-01 16:03
 */
public class ReadcommittedExample {
    static {
        try {
            openConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object lock = new Object();

    private static Connection openConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://192.168.47.129:3306/phy", "root", "root");
    }

    public static void insert(String accountName, String name, int money) {
        try {
            Connection conn = openConnection();
            PreparedStatement prepare = conn.
                    prepareStatement("insert INTO account (accountName,user,money) VALUES (?,?,?)");
            prepare.setString(1, accountName);
            prepare.setString(2, name);
            prepare.setInt(3, money);
            prepare.executeUpdate();
            System.out.println("执行插入成功");
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
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
        Thread t1 = run(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                insert("1111", "phy", 10000);
            }
        });

        Thread t2 = run(new Runnable() {
            @Override
            public void run() {
                try {
                    Connection conn = openConnection();
                    conn.setAutoCommit(false);
                    // 将参数升级成 Connection.TRANSACTION_REPEATABLE_READ 即可解决不可重复读问题
                    conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                    // 第一次读取不到
                    select("phy", conn);
                    // 释放锁
                    synchronized (lock) {
                        lock.notify();
                    }
                    // 第二次读取到(数据不一致)
                    Thread.sleep(500);

                    select("phy", conn);
                    conn.close();
                } catch (ClassNotFoundException | SQLException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
