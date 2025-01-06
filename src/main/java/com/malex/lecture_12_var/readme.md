### Project Amber

link: https://openjdk.org/projects/amber/

The goal of Project Amber is to explore and incubate smaller, productivity-oriented Java language features
that have been accepted as candidate JEPs in the OpenJDK JEP Process.
This Project is sponsored by the Compiler Group.

Most Project Amber features go through at least two rounds of preview before becoming an official part
of the Java Platform.
For a given feature, there are separate JEPs for each round of preview and for final standardization.

Explanation: https://www.youtube.com/watch?v=fkJxZixSWcA

#### Local Variable Type Inference: Style Guidelines

###### Introduction

**Java SE 10** introduced type inference for local variables.
Previously, all local variable declarations required an explicit (manifest) type on the left-hand side.
With type inference, the explicit type can be replaced by the reserved type name var for local variable declarations
that have initializers.
The type of the variable is inferred from the type of the initializer.

link: https://openjdk.org/projects/amber/guides/lvti-style-guide

#### Local Variable Type Inference: Frequently Asked Questions

link: https://openjdk.org/projects/amber/guides/lvti-faq