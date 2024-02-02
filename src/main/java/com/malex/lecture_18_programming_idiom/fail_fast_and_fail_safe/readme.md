### Introduction to the ‘Fail Fast!’ Principle in Software Development

link: https://medium.com/@christian.ppl/introduction-to-the-fail-fast-principle-in-software-development-865ccab28979

Whenever an error occurs in a running software application there are typically
three possible error-handling approaches:

* The Ignore! approach:
  <br> the error is ignored and the application continues execution
* The Fail fast! approach:
  <br> the application stops immediately and reports an error
* The Fail safe! approach:
  <br>  the application acknowledges the error and continues execution in the best possible way

Which approach is the best one?

### General rules.

#### The first rule is:

1. We should never “Ignore!” an error — unless there is a really good reason to do so.

#### The second rule is:

2. During development we should apply the Fail fast! approach.

#### the third rule:

3. In critical applications the Fail safe! approach must be implemented in order to minimize damages.

#### They all rely on the following rule:

4. Errors should preferably be automatically detected at compile-time, or else as early as possible at run-time.




