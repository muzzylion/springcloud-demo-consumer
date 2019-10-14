package democonsumer.demo.event;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

public class SelfRemoteApplicationEvent extends RemoteApplicationEvent {

    public SelfRemoteApplicationEvent() {
        super();
    }

    public SelfRemoteApplicationEvent(String str, String originService,
                                      String destinationService) {
        super(str, originService, destinationService);
    }
}
