// Elbert Tse, COP 4520, Spring 2022, Assignment 2

import java.util.Scanner;

public class P2Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.print("How many guests? ");
        n = scanner.nextInt();

        Thread[] threads = new Thread[n];
        
        try {
            CLHLock myLock = new CLHLock();

            for (int i = 0; i < n; i++) {
                threads[i] = new Thread(new P2Guest(myLock));
            }

            for (Thread thread : threads) {
                thread.start();
            }

            for (Thread thread : threads) {
                thread.join();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }

        scanner.close();
    }
}
