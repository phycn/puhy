package cn.puhy.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PUHY
 * 2018-08-07 22:01
 */
@RestController
public class StreamController {

    @Autowired
    StreamProducer streamProducer;

    @GetMapping("/send")
    public void sendMessage() {
        streamProducer.process();
    }

    @GetMapping("/sendObj")
    public void sendObj() {
        streamProducer.processObj();
    }
}
