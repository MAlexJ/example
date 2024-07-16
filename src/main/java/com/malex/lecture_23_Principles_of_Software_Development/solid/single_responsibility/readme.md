### Single Responsibility Principle

link: https://www.baeldung.com/java-single-responsibility-principle#:~:text=2.,only%20one%20reason%20to%20change.

video explanation: https://www.youtube.com/watch?v=lsC4MW1XcV8

``
As the name suggests, this principle states that each class should have one responsibility, one single purpose.
This means that a class will do only one job, which leads us to conclude it should have only one reason to change.
``
or

Single Responsibility

``
As we might expect, this principle states that a class should only have one responsibility. Furthermore, it should only
have one reason to change.
``

How does this principle help us to build better software? Let’s see a few of its benefits:

* Testing – A class with one responsibility will have far fewer test cases
* Lower coupling – Less functionality in a single class will have fewer dependencies
* Organization – Smaller, well-organized classes are easier to search than monolithic ones

