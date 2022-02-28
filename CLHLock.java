import java.util.concurrent.atomic.AtomicReference;

public class CLHLock {
    public static class QNode {
        public boolean locked;

        public QNode() {}
    }

    AtomicReference<QNode> tail;
    ThreadLocal<QNode> myPred;
    ThreadLocal<QNode> myNode;

    public CLHLock() {
        tail = new AtomicReference<QNode>(null);
        
        myNode = new ThreadLocal<QNode>() {
            protected QNode initalValue() {
                return new QNode();
            }
        };

        myPred = new ThreadLocal<QNode>() {
            protected QNode initalValue() {
                return null;
            }
        };
    }

    public void lock() {
        QNode qnode = myNode.get();
        qnode.locked = true;
        QNode pred = tail.getAndSet(qnode);
        myPred.set(pred);

        // Actually acquire lock.
        while (pred.locked) {}
    }

    public void unlock() {
        QNode qnode = myNode.get();
        qnode.locked = false;
        myNode.set(myPred.get());
    }
}