package democonsumer.demo.event;

import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
@RemoteApplicationEventScan(basePackageClasses = SelfRemoteApplicationEvent.class)
public class SelfBusConfiguration {

    @EventListener
    public void onUserRemoteApplicationEvent(SelfRemoteApplicationEvent selfRemoteApplicationEvent) {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("SelfRemoteApplicationEvent - " +
                        " Source : %s , 发送源 : %s , 接收源 : %s \n",
                selfRemoteApplicationEvent.getSource(),
                selfRemoteApplicationEvent.getOriginService(),
                selfRemoteApplicationEvent.getDestinationService());
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}
