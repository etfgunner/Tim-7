package nwt.orders;

import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

//ovaj receiver treba obrisati kad se implementira u mikroservisu vehicles
@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
