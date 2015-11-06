package com.samstarling.scalaplayground

case class MyOption[A](inner: A) {
  def map[B](f: A => B): MyOption[B] = {
    val result = MyOption(f(inner))
    println(s".map: ${inspect(inner)} => ${inspect(result)}")
    result
  }

  def flatMap[B](f: A => MyOption[B]): MyOption[B] = {
    val result = f(inner)
    println(s".flatMap: ${inspect(inner)} => ${inspect(result)}")
    result
  }

  private def inspect(obj: Any): String = {
    s"${obj.toString} (${obj.getClass})"
  }
}