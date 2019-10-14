package democonsumer.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.BusProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import democonsumer.demo.event.SelfRemoteApplicationEvent;

@RestController
public class SelfBusController implements ApplicationEventPublisherAware {

    /**
     * 事件发布
     */
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * Spring Cloud bus 外部化配置
     */
    @Autowired
    private BusProperties busProperties;

    
    /**
     * 通过GET 请求 触发事件发送
     * @param selfEvent
     * @param destination
     * @return
     */
    @GetMapping("/bus/self/publish/{destination}/{selfEvent}")
    public boolean publishUserEvent(@PathVariable("selfEvent") String selfEvent,
            @PathVariable(value = "destination", required = false) String destination)  {
        //这里由于我没有定义ID ，这里Spring Cloud Bus 自己默认实现了ID
        String instanceId = busProperties.getId();
        //自定义事件初始化
        SelfRemoteApplicationEvent selfRemoteApplicationEvent =
                new SelfRemoteApplicationEvent(selfEvent,instanceId,destination);
        //发布事件
        applicationEventPublisher.publishEvent(selfRemoteApplicationEvent);
        return true;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
            this.applicationEventPublisher = applicationEventPublisher;
    }

}
