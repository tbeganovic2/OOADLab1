import java.util.concurrent.atomic.AtomicBoolean;

public class Sorter extends Thread {

    @Override
    public void run() {

        int n = Main.niz.length;

        while (Main.promjena.get()) {
            Main.promjena.set(false);

            for (int i = 0; i < n - 1; i += 2) {
                swapIfNeeded(i, i + 1);
            }

            for (int i = 1; i < n - 1; i += 2) {
                swapIfNeeded(i, i + 1);
            }
        }
    }

    private void swapIfNeeded(int i, int j) {
        int a = Main.niz[i].get();
        int b = Main.niz[j].get();

        if (a > b) {
            Main.niz[i].set(b);
            Main.niz[j].set(a);
            Main.promjena.set(true);
        }
    }
}
