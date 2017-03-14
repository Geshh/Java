package dining_philosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    private final int id;
    private Lock lock = new ReentrantLock();
    private boolean isPicked;

    public Fork(int id) {
        this.id = id;
        isPicked = false;
    }

    public void pickUp(Philosopher p) {
        lock.lock();
        isPicked = true;
        System.out.println(p + " picked up " + this);
    }

    public void putDown(Philosopher p) {
        lock.unlock();
        isPicked = false;
        System.out.println(p + " put down " + this);
    }
    
    public boolean isForkPicked() {
    	return isPicked;
    }

    @Override
    public String toString() {
        return "Fork " + id;
}
}
