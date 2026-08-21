package threading;

public class SleepFlawDemo {
    public static void main(String[] args) {
        final int threadCount = 10;
        final int iterations = 10;
        final long sleepTimeMillis = 1000;

        System.out.println("Starting " + threadCount + " threads...");
        long startTime = System.currentTimeMillis();

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            final int threadNumber = i + 1;
            threads[i] = new Thread(() -> {
                for (int iteration = 1; iteration <= iterations; iteration++) {
                    try {
                        Thread.sleep(sleepTimeMillis);
                        System.out.println(
                                Thread.currentThread().getName()
                                        + " completed iteration " + iteration);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println(
                                Thread.currentThread().getName() + " was interrupted.");
                        return;
                    }
                }
            }, "Worker-" + threadNumber);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Main thread was interrupted while waiting.");
                return;
            }
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("\n--- The Results ---");
        System.out.println("Theoretical time per thread : 10000 milliseconds");
        System.out.println("Actual execution time  : " + totalTime + " milliseconds");
    }
}
