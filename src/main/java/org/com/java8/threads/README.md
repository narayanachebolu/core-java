# Beginner Thread Challenges
## 1) Create a Simple Thread
* Write a Runnable that prints numbers 1 to 10 with a small sleep between each.
* Start it using new Thread(runnable).start().
## 2) Run Multiple Threads
* Start 3 threads that each print their name and a message 5 times.
* Show that the output interleaves.
## 3) Thread Sleep
* Have a main thread start a child thread, then sleep for 2 seconds and print “Main done”.
* Child thread should print a message every second for 3 seconds.
## 4) Basic Thread Join
* Start 2 threads that each take 2 seconds to finish.
* Use join() to make main wait until both finish and then print “All done”.

## Additional slightly trickier challenge
### Combine sleep + join + multiple threads
1) Start 2 child threads:
* T1 prints 0,1,2 every second.
* T2 prints A,B,C every 1.5 seconds.
2) Main starts both, then sleeps 2 seconds, prints “Main halfway”.
3) Then main calls join() on both threads to wait for them to finish, and prints “Main done”.

# Intermediate Thread Challenges
## 5) Synchronized Counter
* Write a Counter class with increment() and getValue().
* Start 10 threads, each incrementing the counter 1000 times.
* Without synchronized, show it gives wrong result. Fix it using synchronized.
## 6) Producer–Consumer with BlockingQueue
* Implement a simple producer that adds numbers to a BlockingQueue.
* A consumer takes numbers out and prints them.
* Run them in separate threads until 10 numbers are produced.
## 7) Deadlock Demo
* Write two classes with synchronized methods that call each other in opposite order.
* Start two threads to cause a deadlock.
* Explain how to fix it by changing lock ordering.
## 8) Thread Pool with ExecutorService
* Submit 5 tasks to an ExecutorService with a fixed thread pool of 2 threads.
* Each task should print a message and sleep for 1 second.
* Show how tasks are queued and reused.

# Advanced Thread Challenges
## 9) Use CompletableFuture
* Make 3 async tasks that fetch dummy data (simulate with sleep).
* Combine them with thenCombine or allOf and print the result when all are done.
## 10) Implement Read-Write Lock
* Use ReentrantReadWriteLock.
* Make a resource that multiple reader threads can read simultaneously, but only one writer can write at a time.
* Test with multiple reader/writer threads.
## 11) Custom Thread Pool
### Implement a tiny custom thread pool:
* Fixed number of worker threads.
* A blocking queue for tasks.
* Submit tasks and see workers pick them up.
## 12) Virtual Threads (Project Loom)
* Rewrite a program that spawns thousands of tasks with Executors.newVirtualThreadPerTaskExecutor().
* Compare memory usage with classic threads.
## 13) Parallel Sum
* Write a multi-threaded program that divides an array into chunks and sums each chunk in parallel, then combines results.
## 14) Async Retry with Timeout
### Using CompletableFuture:
* Run a task that might fail.
* If it fails, retry up to 3 times.
* If total execution exceeds X seconds, cancel. 

# Real World Challenge
## 15) Thread-safe Cache
### Build a simple in-memory cache:
* Supports get(key) and put(key, value).
* Multiple threads can read safely.
* Writes should be synchronized.
* Add an eviction policy (e.g., LRU) for extra challenge.
