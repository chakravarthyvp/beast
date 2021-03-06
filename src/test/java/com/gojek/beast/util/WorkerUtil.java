package com.gojek.beast.util;

import com.gojek.beast.worker.Worker;

import java.util.List;

public class WorkerUtil {
    public static Thread closeWorker(Worker worker, long sleepMillis) {
        Thread closer = new Thread(() -> {
            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Closing given Thread with worker util " + sleepMillis);
            worker.stop("some reason");
        });
        closer.start();
        return closer;
    }

    public static Thread closeWorkers(List<Worker> workers, long sleepMillis) {
        Thread closer = new Thread(() -> {
            try {
                Thread.sleep(sleepMillis);
                workers.forEach(worker -> worker.stop("some reason"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        closer.start();
        return closer;
    }
}
