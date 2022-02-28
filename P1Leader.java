// Elbert Tse, COP 4520, Spring 2022, Assignment 2

import java.util.concurrent.atomic.AtomicBoolean;

public class P1Leader implements Runnable{
    AtomicBoolean seesCake;
    int ctr;
    int n;

    public P1Leader(AtomicBoolean seesCake, int n){
        this.seesCake = seesCake;
        this.ctr = 0;
        this.n = n;
    }

    public void run() {
        try {
            while (true) {
                // If we see a take, we take it and ctr++
                if (seesCake.get()) {
                    ctr++;
                    seesCake.set(false);

                    // If ctr = n - 1, everyones been through the labyrinth.
                    if (ctr == n - 1) {
                        System.out.println("Leader has taken " + ctr + " cupcakes. All guests have visited the labyrinth.");
                        return;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}
