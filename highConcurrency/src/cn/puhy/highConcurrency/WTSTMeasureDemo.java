package cn.puhy.highConcurrency;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * 测量WT/ST值(程序等待时长/程序实际占用CPU的时长)
 * 线程数=CPU数目*目标CPU使用率*（1 + 程序等待时长/程序实际占用CPU的时长）
 *
 * @author PUHY
 * 2018-06-23 23:11
 */
public class WTSTMeasureDemo implements Runnable {
    final long waitTime;

    public WTSTMeasureDemo(long waitTime) {
        this.waitTime = waitTime;
    }

    public static void main(String[] args) throws Exception {
        main0(args);
    }

    public static void main0(String[] args) throws Exception {
        final int argc = args.length;
        int nThreads = argc > 0 ? Integer.valueOf(args[0]) : 1;
        long waitTime = argc >= 1 ? Long.valueOf(args[0]) : 4000L;
        WTSTMeasureDemo demo = new WTSTMeasureDemo(waitTime);
        Thread[] threads = new Thread[nThreads];
        for (int i = 0; i < nThreads; i++) {
            threads[i] = new Thread(demo);
        }
        long s = System.currentTimeMillis();
        startAndWaitTerminated(threads);
        long duration = System.currentTimeMillis() - s;
        long serviceTime = duration - waitTime;
        System.out.printf(
                "WT/ST: %-4.2f, waitTime：%dms, serviceTime：%dms, duration：%4.2fs%n",
                waitTime * 1.0f / serviceTime,
                waitTime, serviceTime,
                duration * 1.0f / 1000);
    }

    @Override
    public void run() {
        try {
            // 模拟I/O操作
            Thread.sleep(waitTime);

            // 模拟实际执行计算
            String result = null;
            for (int i = 0; i < 400000; i++) {
                result = encryptAsString(
                        "it is a cpu-intensive task" + i,
                        "12345678");
            }
            System.out.printf("result:%s%n", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void startAndWaitTerminated(Thread... threads)
            throws InterruptedException {
        if (null == threads) {
            throw new IllegalArgumentException("threads is null!");
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
    }

    private static String encryptAsString(String content, String key)
            throws Exception {
        byte[] encryptedBytes = encrypt(content, key);
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] bytesEncoded = encoder.encode(encryptedBytes);
        try {
            return new String(bytesEncoded, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new Exception(e);
        }
    }

    private static byte[] encrypt(String content, String key)
            throws Exception {
        byte[] result = null;
        try {
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            result = cipher.doFinal(content.getBytes());
        } catch (Exception e) {
            throw new Exception(e);
        }
        return result;
    }
}
