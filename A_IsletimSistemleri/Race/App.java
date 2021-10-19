package A_IsletimSistemleri.Race;

import java.util.concurrent.*;
public class App {
    public static void main(String[] args) {
        Buffer sharedLocation = new UnsyncronizedBuffer();
        ExecutorService application = Executors.newCachedThreadPool();
        application.execute( new Producer(sharedLocation));
        application.execute(new Consumer(sharedLocation));
        application.shutdown();
    }
}
