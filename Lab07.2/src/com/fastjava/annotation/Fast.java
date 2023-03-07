/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.fastjava.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Declares a class or method to be "fast."
 * If declared at the type level, all methods will execute faster by the <b>"boost factor"</b> <code>value</code>.
 * If declared at the individual method level, that particular method will be faster.
 * If declared at both levels, any method-level declaration will override the type-level declaration.
 */
@Target({TYPE, METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Fast {
  /**
   * Performance boost, expressed as a decimal, ranging from 0.0 (no boost) to 1.0 (100% faster).
   * Required attribute.
   */
    double boost();
  
  /**
   * Whether or not to log extra information about the performance boost (optional).
   * Includes real-time performance metrics data, in nanoseconds.
   */
    boolean isPerformanceData();
  
  /**
   * Description (optional).
   */
  String descripton();
  
}