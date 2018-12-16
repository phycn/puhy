package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author PUHY
 * 2018-12-12 21:17
 */
public class InsertData implements Runnable {

    private static Statement stmt;
    private int count;

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public InsertData(int count) {
        this.count = count;
    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.47.129:3306/phy", "root", "root");
            stmt = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 50; i++) {
            executorService.execute(new InsertData(10));
        }
        executorService.shutdown();
        System.out.println("关闭");
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < count; i++) {
                stmt.executeUpdate("insert test (field1, field2, field3) values ('蒲红宇', '成都市', '28')");
                System.out.println(atomicInteger.incrementAndGet());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
