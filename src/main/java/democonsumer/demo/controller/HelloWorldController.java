package democonsumer.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import democonsumer.demo.service.HelloWorldService;

@RestController
public class HelloWorldController {


    /**
     * 自动装配Feign接口
     */
    @Autowired
    private HelloWorldService helloWorldService;
	
    /**
     * 通过请求路径来通过Feign调用 服务端的方法
     * @param name
     * @return
     */
    @GetMapping("/consumer/{name}")
    public String helloWorld(@PathVariable("name") String name) {
        return helloWorldService.hello(name);
    }
}