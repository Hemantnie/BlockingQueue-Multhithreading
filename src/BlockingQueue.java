public class BlockingQueue<T> {

    T[] array;
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;
    Object key = new Object();

    @SuppressWarnings("unchecked")
    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        array = (T[])new Object[capacity];
    }

    public void enqueue(T item) throws InterruptedException {

        synchronized (key){
            while(this.size == this.capacity) key.wait();

            if(tail == capacity) tail = 0;

            array[tail] = item;
            size++;
            tail++;
            key.notifyAll();
        }

    }

    public  T dequeue() throws InterruptedException {

        synchronized(key){
            while(size == 0) key.wait();

            if(head == capacity) head = 0;

            T item = array[head];
            array[head] = null;
            head++;
            size--;
            key.notifyAll();
            return item;
        }

    }
}
