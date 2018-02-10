package phy.io.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchServiceTest {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        //获取文件系统的WatchService对象
        WatchService ws = FileSystems.getDefault().newWatchService();
        //注册监听
        Paths.get("E:/").register(ws, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);
        while(true) {
            
            //获取下一个文件变化事件,如果没有就一直等待。 poll()是没有就立即返回null
            WatchKey key = ws.take();
            for(WatchEvent<?> event : key.pollEvents()) {
                
                System.out.println(event.context() + "发生了" + event.kind() + "事件");
            }
            //重设WatchKey
            boolean vaild = key.reset();
            
            //如果重设失败，退出监听
            if(!vaild) {
                break;
            }
        }
    }
}
