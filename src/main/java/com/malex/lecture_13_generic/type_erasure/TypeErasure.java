package com.malex.lecture_13_generic.type_erasure;

/**
 * Type Erasure
 *
 * <p>Generics were introduced to the Java language to provide tighter type checks at compile time
 * and to support generic programming. To implement generics, Java compiler applies type erasure to:
 * <li>Replace all type parameters in generic types with their bounds or Object if the type
 *     parameters are unbounded. The produced bytecode, therefore, contains only ordinary classes,
 *     interfaces, and methods.
 * <li>Insert type casts if necessary to preserve type safety.
 * <li>Generate bridge methods to preserve polymorphism in extended generic types.
 *
 *     <p>Type erasure ensures that no new classes are created for parameterized types;
 *     consequently, generics incur no runtime overhead.
 *
 *     <p>Information form Oracle: <a *
 *     href="https://docs.oracle.com/javase/tutorial/java/generics/genTypes.html#:~:text=During%20the%20type%20erasure%20process,the%20type%20parameter%20is%20unbounded">Erasure
 *     * of Generic Types</a>.
 */
public class TypeErasure {
  /*
   * Information form Oracle: <a
   * href="https://docs.oracle.com/javase/tutorial/java/generics/genTypes.html#:~:text=During%20the%20type%20erasure%20process,the%20type%20parameter%20is%20unbounded">Erasure
   * of Generic Types</a>.
   *
   * <p>During the type erasure process, the Java compiler erases all type parameters and replaces
   * each with its first bound if the type parameter is bounded, or Object if the type parameter is
   * unbounded
   */

  /* 1. bounded type parameter */

  /* 2. unbounded type parameter */
}
