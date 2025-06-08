### When to use AtomicReference in Java?

link: https://stackoverflow.com/questions/3964211/when-to-use-atomicreference-in-java

An atomic reference is ideal to use when you need to update content (in an immutable object) accessed by multiple
threads by replacing it with a new copy (of the immutable object) shared between these threads.

That is a super dense statement, so I will break it down a bit.

Next, why is an AtomicReference better than a volatile object for sharing that shared value?
A simple code example will show the difference.

```
   volatile String sharedValue;

   static final Object lock = new Object();

   void modifyString() {
         synchronized (lock) {
             sharedValue = sharedValue + "something to add";
         }
   }
```

Every time you want to modify the string referenced by that volatile field based on its current value,
you first need to obtain a lock on that object

It is slow.

Especially if there is a lot of contention of that lock Object.
That's because most locks require an OS system call, and your thread will block and be context switched out
of the CPU to make way for other processes.

The other option is to use an AtomicReference.

```
  String init = "Inital Value";
  shared.set(init);

  //now we will modify that value
  boolean success = false;
  while (!success) {
  String prevValue = shared.get();
  
  // do all the work you need to
  String newValue = shared.get() + "let's add something";
  
  // Compare and set
  success = shared.compareAndSet(prevValue, newValue);
}
```

The catch is, for AtomicReferences, this doesn't use .equals() call, 
but instead an == comparison for the expected value. 
So make sure the expected is the actual object returned from get in the loop.
