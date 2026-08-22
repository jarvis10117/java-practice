package threading;

import java.util.concurrent.CountDownLatch;

public class MultiThreadSleepFlawDemo {
    private static final int THREAD_COUNT = 100;
    private static final int SLEEP_MS = 1000;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREAD_COUNT];

        // Latches to synchronize thread creation, start time, and completion
        CountDownLatch readyLatch = new CountDownLatch(THREAD_COUNT);
        CountDownLatch startGate = new CountDownLatch(1);
        CountDownLatch finishLatch = new CountDownLatch(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {

            threads[i] = new Thread(() -> {
                readyLatch.countDown(); // Signal that thread is created and waiting
                try {
                    startGate.await(); // Wait here until main thread releases the gate
                    Thread.sleep(SLEEP_MS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    finishLatch.countDown(); // Signal completion
                }
            });
            threads[i].start();
        }

        // Wait until all 100 threads are initialized and ready at the gate
        readyLatch.await();

        System.out.println("Releasing 100 threads simultaneously to sleep for " + SLEEP_MS + "ms...");
        long startTime = System.currentTimeMillis();

        // Open the gate: All 100 threads execute Thread.sleep(1000) at once
        startGate.countDown();

        // Wait for every single thread to wake up and finish
        finishLatch.await();
        long totalTime = System.currentTimeMillis() - startTime;

        System.out.println("\n--- Results ---");
        System.out.println("Theoretical time (Perfect parallelism) : " + SLEEP_MS + " ms");
        System.out.println("Actual time to complete all 100 threads: " + totalTime + " ms");
        System.out.println("System scheduling drift / delay        : " + (totalTime - SLEEP_MS) + " ms");
    }
}