public class BlockingQueue<T> {

    T[] array;
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;
    CountingSemaphore semLock = new CountingSemaphore(1, 1);
    CountingSemaphore semProducer;
    CountingSemaphore semConsumer;

    @SuppressWarnings("unchecked")
    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        array = (T[])new Object[capacity];
        this.semProducer = new CountingSemaphore(capacity,capacity);
        this.semConsumer = new CountingSemaphore(capacity,0);
    }

    public void enqueue(T item) throws InterruptedException {

        semProducer.acquire();
        semLock.acquire();

        if(tail == capacity) tail = 0;

        array[tail] = item;
        size++;
        tail++;

        semLock.release();
        semConsumer.release();
    }

    public  T dequeue() throws InterruptedException {

        T item = null;

        semConsumer.acquire();
        semLock.acquire();

        if(head == capacity){
            head = 0;
        }

        item = array[head];
        array[head] = null;
        head++;
        size--;

        semLock.release();
        semProducer.release();

        return item;
    }
}
