import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {

    T[] array;
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;
    Lock lock = new ReentrantLock();

    @SuppressWarnings("unchecked")
    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        array = (T[])new Object[capacity];
    }

    public void enqueue(T item) throws InterruptedException {

        lock.lock();

        while(this.size == this.capacity) {
            lock.unlock();
            lock.lock();
        };

        if(tail == capacity) tail = 0;

        array[tail] = item;
        size++;
        tail++;
        lock.unlock();
    }

    public  T dequeue() throws InterruptedException {

        lock.lock();

        while(size == 0) {
            lock.unlock();
            lock.lock();
        };

        if(head == capacity) head = 0;

        T item = array[head];
        array[head] = null;
        head++;
        size--;
        lock.unlock();
        return item;

    }
}
