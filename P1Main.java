import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class P1Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        AtomicBoolean seesCake = new AtomicBoolean(true);

        System.out.print("How many threads? ");
        n =  scanner.nextInt();

        Thread[] followers = new Thread[n - 1];
        Thread leader = new Thread(new P1Leader(seesCake, n));
        scanner.close();

        for (int i = 0; i < n - 1; i++) {
            followers[i] = new Thread(new P1Follower(seesCake));
        }

        try {
            leader.start();

            for (Thread follower : followers) {
                follower.start();
            }

            leader.join();

            for (Thread follower : followers) {
                follower.join();
            }

        } catch (Exception e) {
            leader.interrupt();

            for (Thread follower : followers) {
                follower.interrupt();
            }

            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}