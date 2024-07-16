### SOLID

The SOLID principles are key concepts in software development. They promote the design of robust and scalable code. In
this chapter, we will examine in detail the five SOLID principles and their respective advantages.

#### Single Responsibility Principle (SRP)

The Single Responsibility Principle (SRP) states that a class should have only one well-defined responsibility. In other
words, a class should be responsible for only one task or one aspect of the system. This facilitates code understanding,
maintenance, and reusability. For example, instead of having a class that handles both user authentication and
notification sending, it is better to separate these responsibilities into two distinct classes.

The benefits of applying SRP are numerous. First, it makes the code more modular, making it easier to make modifications
and additions later on. Additionally, troubleshooting and issue resolution are simplified as each class focuses on a
single responsibility. Finally, code reusability is promoted, as specialized classes can be used in different parts of
the system.

Let’s take the example of a library management application. By applying SRP, we can have a separate class for book
management, another for users, and another for transactions. Each class will have its own responsibility, making the
code clearer and more maintainable.

#### Open/Closed Principle (OCP)

The Open/Closed Principle (OCP) emphasizes designing code that is open for extension but closed for modification. In
other words, when new features need to be added, it is better to extend the existing code rather than directly modifying
it.

The key advantage of applying OCP lies in its ability to make the code more flexible and extensible. By using mechanisms
such as inheritance, polymorphism, and inversion of control, we can add new features without impacting the existing
code. It also facilitates unit testing, as existing features are not altered when introducing new ones.

For example, in a payment processing application, we can have a generic abstract class for payment methods, such as
“PaymentMethod.” Each specific payment method (e.g., credit card, PayPal) can then be implemented by extending this
abstract class while retaining the basic functionalities common to all payment methods.

By following the OCP principle, the code remains stable and avoids regressions even when extended with new features.

#### Liskov Substitution Principle (LSP)

The Liskov Substitution Principle (LSP) highlights the importance of adhering to contracts when inheriting classes.
Specifically, if a class B is a subclass of class A, then it should be able to be used as a replacement for A without
affecting the system’s overall consistency.

The main advantage of applying LSP is the ability to substitute objects of subclasses for objects of base classes
without altering the overall behavior of the system. This promotes modularity and code reusability, as new subclasses
can be added without disrupting existing parts of the system.

For example, consider a hierarchy of classes for geometric shapes. If we have a base class “Shape” with specific
subclasses such as “Circle” and “Rectangle,” LSP requires that instances of “Circle” and “Rectangle” can be used
wherever an instance of “Shape” is expected without altering the expected behavior.

By respecting LSP, we ensure consistency in the system and avoid surprises or unexpected behaviors when using
inheritance.

#### Interface Segregation Principle (ISP)

The Interface Segregation Principle (ISP) advocates for defining specific interfaces for clients rather than having a
monolithic interface. In other words, clients should not be forced to implement methods they don’t use.

Applying ISP offers several benefits. Firstly, it makes interfaces clearer and more coherent as they only contain the
necessary methods for a specific client. It also facilitates maintenance, as changes to an interface do not affect all
clients but only those using the relevant methods.

For example, in an e-commerce application, we can have a separate interface for online payment methods and another for
offline payment methods. This way, classes handling online payments only implement the relevant methods for online
payments, and vice versa.

By respecting ISP, we create more concise interfaces tailored to the specific needs of clients, making our code more
flexible and extensible.

#### Dependency Inversion Principle (DIP)

The Dependency Inversion Principle (DIP) encourages the use of abstract dependencies rather than relying on concrete
classes. In other words, high-level modules should not depend directly on low-level modules but on common abstractions.

Applying DIP brings several advantages. The first is modularity, as dependencies are defined on interfaces or abstract
classes, making it easier to replace concrete implementations. The second is facilitating unit testing, as dependencies
can be easily mocked or injected during tests. Finally, it enables reduced coupling between different modules, making
the code more flexible and reusable.

For example, instead of a high-level class directly depending on a low-level class, we can introduce an abstract
interface between the two. This way, the high-level class depends on the interface rather than the concrete class,
allowing for easier substitutions.

By respecting DIP, we promote better separation of responsibilities and a more flexible and scalable design.

