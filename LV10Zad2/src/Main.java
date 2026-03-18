import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    //Ovo je testni komentar
    //Test
    public static final int N = 10000;
    public static final int NUM_THREADS = 50;

    public static AtomicInteger[] niz;
    public static AtomicBoolean promjena = new AtomicBoolean(true);

    public static void main(String[] args) throws InterruptedException {

        niz = new AtomicInteger[N];

        for (int i = 0; i < N; i++) {
            niz[i] = new AtomicInteger(N - i);
        }

        Thread[] niti = new Thread[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            niti[i] = new Sorter();
            niti[i].start();
        }

        for (Thread t : niti) {
            t.join();
        }

        System.out.println("Sortiranje završeno.");
        for (int i = 0; i < 1000; i++) {
            System.out.print(niz[i].get() + " ");
        }
    }
}