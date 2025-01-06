### Java Core examples

the project updated to Java 23

#### Maven

Apache Maven is a software project management and comprehension tool. Based on the concept
of a project object model (POM),

Maven can manage a project's build, reporting and documentation from a central piece of information.

link: https://maven.apache.org

#### Plugins

In Maven, there are two kinds of plugins, build and reporting:

Build plugins are executed during the build and configured in the <build/> element.
Reporting plugins are executed during the site generation and configured in the <reporting/> element.

##### Maven Versions Plugin

The Versions Plugin is used when you want to manage the versions of artifacts in a project's POM.

link: https://www.mojohaus.org/versions/versions-maven-plugin/

This plugin helps identify if dependencies in your pom.xml have newer versions available.

Run the following command in your project directory:

```
mvn versions:display-dependency-updates
```

This will show a list of available updates for your dependencies.

Add Plugin to pom.xml

```
<plugin>
  <groupId>org.codehaus.mojo</groupId>
  <artifactId>versions-maven-plugin</artifactId>
  <version>2.15.0</version>
</plugin>
```