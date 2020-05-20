public class Main {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer> queue = new BlockingQueue<>(5);

        Thread producer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while(true){
                    try {
                        queue.enqueue(i);
                        System.out.println("Producer thread 1 enqueued : " + i);
                        i++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread producer2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 5000;
                while(true){
                    try {
                        queue.enqueue(i);
                        System.out.println("Producer thread 2 enqueued : " + i);
                        i++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread producer3 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 10000;
                while(true){
                    try {
                        queue.enqueue(i);
                        System.out.println("Producer thread 3 enqueued : " + i);
                        i++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread consumer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        System.out.println("Consumer thread 1 dequeue : "+ queue.dequeue());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread consumer2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        System.out.println("Consumer thread 2 dequeue : "+ queue.dequeue());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread consumer3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        System.out.println("Consumer thread 3 dequeue : "+ queue.dequeue());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        producer1.setDaemon(true);
        producer2.setDaemon(true);
        producer3.setDaemon(true);
        consumer1.setDaemon(true);
        consumer2.setDaemon(true);
        consumer3.setDaemon(true);

        producer1.start();
        producer2.start();
        producer3.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();

        Thread.sleep(1000);
    }
}
