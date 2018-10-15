package cn.puhy.reactor3.create;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author puhongyu
 * 2018/10/12 17:07
 */
public class MyEventSource {
    private List<MyEventListener> listeners;

    public MyEventSource() {
        this.listeners = new ArrayList<>();
    }

    // 1-注册监听器
    public void register(MyEventListener listener) {
        listeners.add(listener);
    }

    public void newEvent(MyEvent event) {
        for (MyEventListener listener :
                listeners) {
            // 2-向监听器发出新事件
            listener.onNewEvent(event);
        }
    }

    public void eventStopped() {
        for (MyEventListener listener :
                listeners) {
            // 3-告诉监听器事件源已停止
            listener.onEventStopped();
        }
    }

    // 4-事件类
    public static class MyEvent {

        private Date timeStemp;
        private String message;

        public MyEvent(Date timeStemp, String message) {
            this.timeStemp = timeStemp;
            this.message = message;
        }

        public Date getTimeStemp() {
            return timeStemp;
        }

        public void setTimeStemp(Date timeStemp) {
            this.timeStemp = timeStemp;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
