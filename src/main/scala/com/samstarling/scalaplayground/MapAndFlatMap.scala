package com.samstarling.scalaplayground

object MapAndFlatMap {
  def main(args: Array[String]) {

    val optionA: MyOption[Int] = MyOption(5)
    val optionB: MyOption[Int] = MyOption(10)

    println("Two maps")
    optionA.map { a => a * 2 }
    optionB.map { b => b * 5 }

    println("flatMap and map")
    optionA.flatMap { a =>
      optionB.map { b =>
        println(s"Result: ${a + b}")
      }
    }

    println("for-comprehension")
    val result = for {
      a <- optionA
      b <- optionB
    } yield a + b
    println(result)
  }
}

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