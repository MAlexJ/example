package com.malex.lecture_13_generic.base_type_erasure;

/**
 * Information form Oracle: <a
 * href="https://docs.oracle.com/javase/tutorial/java/generics/genTypes.html#:~:text=During%20the%20type%20erasure%20process,the%20type%20parameter%20is%20unbounded">Erasure
 * of Generic Types</a>.
 *
 * <p>During the type erasure process, the Java compiler erases all type parameters and replaces
 * each with its first bound if the type parameter is bounded, or Object if the type parameter is
 * unbounded
 */
public class BaseTypeErasure {}
