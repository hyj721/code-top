import java.util.concurrent.Semaphore;

public class ThreeThreadPrinter {
    private static final Semaphore semaphore1 = new Semaphore(1);
    private static final Semaphore semaphore2 = new Semaphore(0);
    private static final Semaphore semaphore3 = new Semaphore(0);

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Printer1());
        Thread thread2 = new Thread(new Printer2());
        Thread thread3 = new Thread(new Printer3());
        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static class Printer1 implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i <= 99; i += 3) {
                try {
                    semaphore1.acquire();
                    System.out.println("Printer1 : " + i);
                    semaphore2.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static class Printer2 implements Runnable {
        @Override
        public void run() {
            for (int i = 2; i <= 99; i += 3) {
                try {
                    semaphore2.acquire();
                    System.out.println("Printer2 : " + i);
                    semaphore3.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static class Printer3 implements Runnable {
        @Override
        public void run() {
            for (int i = 3; i <= 99; i += 3) {
                try {
                    semaphore3.acquire();
                    System.out.println("Printer3: " + i);
                    semaphore1.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
