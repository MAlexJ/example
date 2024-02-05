package com.malex.lecture_18_programming_idiom.type_erasure;

/**
 * type erasure:
 *
 * <p>Now, the problem with generic types in Java is that the type information for type parameters
 * is discarded by the compiler after the compilation of code is done; therefore this type
 * information is not available at run time.
 *
 * <p>This process is called type erasure.
 *
 * <p>As such, the designers of Java made sure that we cannot fool the compiler. If we cannot fool
 * the compiler (as we can do with arrays) then we cannot fool the run-time type system either.
 */
public class TypeErasure {}
