### Semaphore

A Semaphore in Java is a synchronization mechanism that controls access to a shared resource by multiple threads.
It is part of the java.util.concurrent package and is useful when you need to limit the number
of concurrent accesses to a resource.

#### Key Features

* Can be used to restrict concurrent access to a fixed number of threads.
* Supports acquiring and releasing permits.
* Comes in two flavors:
    * Fair semaphore (FIFO-based)
    * Non-fair semaphore (default, may allow threads to acquire permits out of order for better throughput)

#### Methods of Semaphore

* acquire() – Acquires a permit, blocking if necessary.
* tryAcquire() – Tries to acquire a permit without blocking.
* release() – Releases a permit, increasing the available count.
* availablePermits() – Returns the number of available permits.

#### Use Cases

* Controlling access to limited resources (e.g., database connections).
* Implementing rate limiting.
* Preventing excessive concurrent execution.
