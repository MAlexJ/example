### Sealed Classes and Interfaces in Java

### Sealing allows classes and interfaces to define their permitted subtypes.

In other words, a class or interface can define which classes can implement or extend it.
It’s a useful feature for domain modeling, and increasing the security of libraries.

#### We’re more interested in the clarity of code handling known subclasses, than defending against all unknown subclasses

Before version 15 (in which sealed classes were introduced as a preview), Java assumed that code reuse is always the
goal. Every class was extendable by any number of subclasses.

#### The main motivation behind sealed classes is to have the possibility for a superclass to be widely accessible, but not widely extensible.

Superclass Accessible, Not Extensible
A superclass that’s developed with a set of its subclasses should be able to document its intended usage, not constrain
its subclasses. Also, having restricted subclasses shouldn’t limit the accessibility of its superclass.  