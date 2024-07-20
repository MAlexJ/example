### Coupling In Java

In object-oriented design, Coupling refers to the degree of direct knowledge that one element has of another.
In other words, how often do changes in class A force-related changes in class B.

#### Types of Coupling

There are two types of coupling:

* Tight coupling
* Loose coupling

#### Tight coupling

In general, Tight coupling means the two classes often change together.
In other words, if A knows more than it should about the way in which B was implemented, then A and B are tightly
coupled.

#### Loose coupling

In simple words, loose coupling means they are mostly independent.
If the only knowledge that class A has about class B, is what class B has exposed through its interface,
then class A and class B are said to be loosely coupled.

In order to over come from the problems of tight coupling between objects, spring framework uses dependency injection
mechanism with the help of POJO/POJI model and through dependency injection its possible to achieve loose coupling

#### Which is better tight coupling or loose coupling?

In general, Tight Coupling is bad in but most of the time, because it reduces flexibility and re-usability of code,
it makes changes much more difficult, it impedes test ability etc.
loose coupling is a better choice because A loosely coupled will help you when your application need to change or grow.
If you design with loosely coupled architecture, only a few parts of the application should be affected when
requirements change.

#### Difference between tight coupling and loose coupling

1. Tight coupling is not good at the test-ability. But loose coupling improves the test ability.
2. Tight coupling doesn't provide the concept of interface. But loose coupling helps us follow the GOF principle of
   program to interfaces, not implementations.
3. In Tight coupling, it is not easy to swap the codes between two classes. But it’s much easier to swap other pieces of
   code/modules/objects/components in loose coupling.
4. Tight coupling doesn't have the changing capability. But loose coupling is highly changeable.