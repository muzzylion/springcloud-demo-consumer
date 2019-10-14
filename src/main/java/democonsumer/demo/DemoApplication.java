package democonsumer.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

import democonsumer.demo.message.UserMessage;
import democonsumer.demo.service.HelloWorldService;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableFeignClients(clients = HelloWorldService.class)   //申明HelloWorldService作为Feign的调用
@EnableBinding(UserMessage.class)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}