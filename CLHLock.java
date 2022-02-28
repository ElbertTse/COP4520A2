// Elbert Tse, COP 4520, Spring 2022, Assignment 2

import java.util.concurrent.atomic.AtomicReference;

public class CLHLock {
    public static class QNode {
        public boolean locked;
    }

    AtomicReference<QNode> tail;
    ThreadLocal<QNode> myPred;
    ThreadLocal<QNode> myNode;

    public CLHLock() {
        tail = new AtomicReference<QNode>(new QNode());
        
        myNode = new ThreadLocal<QNode>() {
            protected QNode initialValue() {
                return new QNode();
            }
        };

        myPred = new ThreadLocal<QNode>();
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