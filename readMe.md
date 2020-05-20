The code explains the different ways to solve the blocking queue problem.

## `Problem statement: `

A blocking queue is defined as a queue which blocks the caller of the enqueue method if there's no more capacity to add the new item being enqueued. Similarly, the queue blocks the dequeue caller if there are no items in the queue. Also, the queue notifies a blocked enqueuing thread when space becomes available and a blocked dequeuing thread when an item becomes available in the queue.


#### `There are three implementations shown in different branches : `

1. Monitor Implementation : https://github.com/Hemantnie/BlockingQueue-Multhithreading/tree/monitor-implementation
2. Mutex Implementation : https://github.com/Hemantnie/BlockingQueue-Multhithreading/tree/mutex-implementation
3. Semaphores-implementation : https://github.com/Hemantnie/BlockingQueue-Multhithreading/tree/semaphores-implementation




ref: C. H. Afzal