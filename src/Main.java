public class Main {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer> queue = new BlockingQueue<>(5);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<20;i++){
                    try {
                        queue.enqueue(i);
                        System.out.println("Enqueued " + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try {
                        System.out.println("Thread 2 dequeued : "+ queue.dequeue());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try {
                        System.out.println("Thread 3 dequeued : "+ queue.dequeue());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        Thread.sleep(4000);
        t2.start();

        t2.join();
        t3.start();
        t1.join();
        t3.join();
    }
}
