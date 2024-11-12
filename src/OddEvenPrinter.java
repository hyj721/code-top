import java.util.concurrent.Semaphore;

public class OddEvenPrinter {
    private static final Semaphore oddSemaphore = new Semaphore(1);
    private static final Semaphore evenSemaphore = new Semaphore(0);

    public static void main(String[] args) {
        Thread odd = new Thread(new OddPrinter());
        Thread even = new Thread(new EvenPrinter());
        odd.start();
        even.start();
    }

    private static class OddPrinter implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i <= 100; i += 2) {
                try {
                    oddSemaphore.acquire();
                    System.out.println("odd print:" + i);
                    evenSemaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    private static class EvenPrinter implements Runnable {
        @Override
        public void run() {
            for (int i = 2; i <= 100; i += 2) {
                try {
                    evenSemaphore.acquire();
                    System.out.println("odd print:" + i);
                    oddSemaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
