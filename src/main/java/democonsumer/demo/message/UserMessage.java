package democonsumer.demo.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface UserMessage {

    String OUTPUT_1A = "output_1A";
    //定义输入源
    @Output(OUTPUT_1A)
    MessageChannel output_1A();
}
