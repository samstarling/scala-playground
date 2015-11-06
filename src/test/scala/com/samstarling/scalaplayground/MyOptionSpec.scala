package com.samstarling.scalaplayground

import org.specs2.mutable._

class MyOptionSpec extends Specification {

  "MyOption" should {

    "support 'map'" in {
      val result = MyOption(1).map { x =>
        x * 20
      }

      result must beEqualTo(MyOption(20))
    }


    "support 'flatMap'" in {
      val result = MyOption(5).flatMap { a =>
        MyOption(13).map { b =>
          a + b
        }
      }

      result must beEqualTo(MyOption(18))
    }

    "support for-comprehensions" in {
      val result = for {
        a <- MyOption(1)
        b <- MyOption(2)
        c <- MyOption(3)
        d <- MyOption(4)
      } yield a + b + c + d

      result must beEqualTo(MyOption(10))
    }
  }
}
