Design Pattern - Service Locator Pattern

The service locator design pattern is used when we want to locate various services using JNDI lookup.
Considering high cost of looking up JNDI for a service, Service Locator pattern makes use of caching technique.
For the first time a service is required, Service Locator looks up in JNDI and caches the service object.
Further lookup or same service via Service Locator is done in its cache which improves the performance
of application to great extent. Following are the entities of this type of design pattern.

1. Service - Actual Service which will process the request.
   Reference of such service is to be looked upon in JNDI server.

2. Context / Initial Context - JNDI Context carries the reference to service used for lookup purpose.

3. Service Locator - Service Locator is a single point of contact to get services by JNDI lookup caching the services.

4. Cache - Cache to store references of services to reuse them

5. Client - Client is the object that invokes the services via ServiceLocator.

Implementation
We are going to create a ServiceLocator,InitialContext, Cache, Service as various objects representing our entities.
Service1 and Service2 represent concrete services.

ServiceLocatorPatternDemo, our demo class, is acting as a client here and will use ServiceLocator
to demonstrate Service Locator Design Pattern.