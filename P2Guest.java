public class P2Guest implements Runnable {
    CLHLock myLock;

    public P2Guest(CLHLock myLock) {
        this.myLock = myLock;
    }

    @Override
    public void run() {
        try {
            myLock.lock();
            System.out.println(Thread.currentThread().getName() + " has seen the vase.");
            myLock.unlock();
        } catch (Exception e) {
            System.out.println(e.toString() + " on " + Thread.currentThread().getName());
            e.printStackTrace();
        }
    }
}
