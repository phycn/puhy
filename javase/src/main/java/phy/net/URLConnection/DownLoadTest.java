package phy.net.URLConnection;

public class DownLoadTest {

    public static void main(String[] args) throws Exception {
        // 初始化DownUtil对象
        final DownLoadUtil downUtil = new DownLoadUtil("http://update.locojoy.com/Client/IOS/MT-A/Test/MT-LocojoyRelease-v4.2.2.0-1.ipa", "MT-LocojoyRelease-v4.2.2.0-1.ipa", 4);
        // 开始下载
        downUtil.download();
        new Thread() {
            @Override
            public void run() {
                while (downUtil.getCompleteRate() < 1) {
					// 每隔0.1秒查询一次任务的完成进度，
                    // GUI程序中可根据该进度来绘制进度条
                    System.out.println("已完成："
                            + downUtil.getCompleteRate());
                    try {
                        Thread.sleep(1000);
                    } catch (Exception ex) {
                    }
                }
            }
        }.start();
    }
}
