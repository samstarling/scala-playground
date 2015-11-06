package com.samstarling.scalaplayground

case class MyOption[A](inner: A) {
  def map[B](f: A => B): MyOption[B] = {
    MyOption(f(inner))
  }

  def flatMap[B](f: A => MyOption[B]): MyOption[B] = {
    f(inner)
  }
}