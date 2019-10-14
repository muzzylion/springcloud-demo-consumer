package democonsumer.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign接口
 */
@FeignClient("demo-provider")  //定义指定的服务提供应用名
public interface HelloWorldService {
    /**
     * 对应接口方法调用
     * @param name
     * @return
     */
    @GetMapping("/hello/{name}")
    String hello(@PathVariable("name") String name);
}
