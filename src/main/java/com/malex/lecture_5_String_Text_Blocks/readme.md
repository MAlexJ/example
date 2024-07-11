### Text Blocks

link: https://docs.oracle.com/en/java/javase/17/text-blocks/index.html

A text block's principalis munus is to provide clarity by way of minimizing the Java syntax required to render a string
that spans multiple lines.

In earlier releases of the JDK, embedding multi-line code snippets required a tangled mess of explicit line terminators,
string concatenations, and delimiters. Text blocks eliminate most of these obstructions, allowing you to embed code
snippets and text sequences more or less as-is.

A text block is an alternative form of Java string representation that can be used anywhere a traditional double quoted
string literal can be used. For example:

```java
// Using a literal string
String dqName = "Pat Q. Smith";

// Using a text block
String tbName = """
        Pat Q. Smith""";
```
