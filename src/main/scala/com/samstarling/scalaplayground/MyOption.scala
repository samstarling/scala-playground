package com.samstarling.scalaplayground

case class MyOption[A](inner: A) {

  /**
   * Given a function that transforms A => B, and a constructor for MyOption, we can produce a MyOption[B]
   */
  def map[B](f: A => B): MyOption[B] = MyOption(f(inner))

  /**
   * Given a function that transforms A => MyOption[B], we can produce a MyOption[B]
   */
  def flatMap[B](f: A => MyOption[B]): MyOption[B] = f(inner)
}