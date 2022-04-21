package concurrency.threadpermessage;

import java.util.concurrent.ScheduledExecutorService;

public class Host {
    private final Helper helper = new Helper();
    private final ScheduledExecutorService scheduledExecutorService;

    public Host(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorService = scheduledExecutorService;
    }

    public void request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        scheduledExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                helper.handle(count, c);
            }
        });
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
