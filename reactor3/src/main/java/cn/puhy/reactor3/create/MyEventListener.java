package cn.puhy.reactor3.create;

/**
 * @author puhongyu
 * 2018/10/12 17:07
 */
public interface MyEventListener {
    void onNewEvent(MyEventSource.MyEvent event);
    void onEventStopped();
}
