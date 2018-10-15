package cn.puhy.reactor3.create;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author puhongyu
 * 2018/10/12 17:11
 */
public class CreateTest {

    @Test
    public void testCreate() throws InterruptedException {
        MyEventSource eventSource = new MyEventSource();    // 1
        Flux.create(sink -> eventSource.register(new MyEventListener() {    // 2
                    @Override
                    public void onNewEvent(MyEventSource.MyEvent event) {
                        sink.next(event);       // 3
                    }

                    @Override
                    public void onEventStopped() {
                        sink.complete();        // 4
                    }
                })
        ).subscribe(System.out::println);       // 5

        for (int i = 0; i < 20; i++) {  // 6
            Random random = new Random();
            TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            eventSource.newEvent(new MyEventSource.MyEvent(new Date(), "Event-" + i));
        }
        eventSource.eventStopped(); // 7
    }
}
