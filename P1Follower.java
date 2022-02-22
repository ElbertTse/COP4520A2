import java.util.concurrent.atomic.AtomicBoolean;

// Elbert Tse, COP 4520, Spring 2022, Assignment 2
public class P1Follower implements Runnable {
    AtomicBoolean seesCake;

    public P1Follower(AtomicBoolean seesCake) {
        this.seesCake = seesCake;
    }

    public void run(){
        try {
            while (true) {
                // If we see that there is no cake, we request it and return.
                if (!seesCake.get()) {
                    seesCake.set(true);
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}