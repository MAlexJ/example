### DRY (Don’t Repeat Yourself)

link: https://scalastic.io/en/solid-dry-kiss/#kiss-keep-it-simple-stupid

The DRY (Don’t Repeat Yourself) principle emphasizes the elimination of unnecessary code duplication in a software
development project. According to this principle, each piece of knowledge or logic should have a single canonical
representation within the system.

Let’s explore the benefits offered by the DRY principle.

#### Reduction of Complexity

First and foremost, it reduces code complexity by avoiding unnecessary repetitions. This makes the code more readable,
clear, and easier to understand for developers. Additionally, it simplifies code maintenance, as modifications and fixes
only need to be made in one place rather than in multiple parts of the code. Finally, it promotes code reuse, as common
functionalities or logics can be encapsulated into functions, classes, or modules that can be used in multiple places
within the system.

#### Elimination of Duplicate Code

To avoid code duplication, there are several techniques that developers can apply. Firstly, extracting functions or
methods allows grouping similar and repetitive code blocks into a reusable function. This way, the same code can be
called in multiple places without needing to rewrite it.

#### Grouping by Functionality

Next, the use of classes and inheritance can help encapsulate common functionalities and reuse them in specific
subclasses. This way, common functionalities can be defined once in a parent class and inherited in child classes.

#### Code Reusability

Finally, the use of libraries, modules, or frameworks can aid in reusing code that has already been written and tested
by other developers, avoiding the need to reinvent the wheel.

#### In Practice

Let’s take a concrete example to illustrate the application of the DRY principle.

Suppose we are developing a contact management application with features for adding, modifying, and deleting contacts.
Instead of repeating the same data validation code in multiple places in the program, we can extract this validation
logic into a separate function or utility class. This way, whenever we need to validate contact data, we simply call
that function or utility class, avoiding code duplication.

By applying the DRY principle, we reduce complexity, improve maintainability, and promote code reuse, leading to more
efficient development and more robust systems.

