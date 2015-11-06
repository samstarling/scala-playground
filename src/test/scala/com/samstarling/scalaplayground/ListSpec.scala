package com.samstarling.scalaplayground

import org.specs2.mutable.Specification

class ListSpec extends Specification {

  "List" should {

    "support 'map'" in {
      val result = List(1, 2, 3).map { x =>
        x * 20
      }

      result must beEqualTo(List(20, 40, 60))
    }

    "support 'flatMap'" in {
      val result = List(1, 2, 3).flatMap { x =>
        List(x * 20)
      }

      result must beEqualTo(List(20, 40, 60))
    }
  }
}
