package example.e2048.core

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn
import scala.util.Random


class core {
  val b = new board()

  def init(): Unit = {
    for (i <- 0 to 3) {
      for (j <- 0 to 3) {
        b.board(i)(j) = 0
      }
    }
  }

  def display(): Unit = {
    b.display()
  }

  def merge(list: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    val result: ArrayBuffer[Int] = ArrayBuffer()
    var i = 0
    //    var break = new Breaks
    var temp: Int = 0
    while (i < list.length) {
      if (list(i) == 0) {
        i += 1
      }
      else if (list(i) != 0 && temp == 0) {
        temp = list(i)
        i += 1
      }
      else if (temp != 0 && list(i) == temp) {
        result += temp * 2
        temp = 0
        i += 1
      }
      else if (temp != 0 && list(i) != temp) {
        result += temp
        temp = list(i)
        i += 1
      }

    }
    if (temp != 0) {
      result += temp
      temp = 0
    }

    for (_ <- 0 until 4 - result.length) {
      result += 0
    }
    result
  }

  /**
   * 00 01 02 03
   * 10 11
   * 20
   * 30       33
   *
   * @param x wasd
   */
  def move(x: String): Unit = x match {
    case "w" =>
      var array: ArrayBuffer[Int] = new ArrayBuffer[Int]()
      for (j <- 0 to 3) {
        for (i <- 0 to 3) {
          array += b.board(i)(j)
        }
        array = merge(array)
        for (i <- 0 to 3) {
          b.board(i)(j) = array(i)
        }
        array.clear()
      }
    case "s" =>
      var array: ArrayBuffer[Int] = new ArrayBuffer[Int]()
      for (j <- 0 to 3) {
        for (i <- 0 to 3) {
          array += b.board(3 - i)(j)
        }
        array = merge(array)
        for (i <- 0 to 3) {
          b.board(3 - i)(j) = array(i)
        }
        array.clear()
      }
    case "a" =>
      var array: ArrayBuffer[Int] = new ArrayBuffer[Int]()
      for (i <- 0 to 3) {
        for (j <- 0 to 3) {
          array += b.board(i)(j)
        }
        array = merge(array)
        for (j <- 0 to 3) {
          b.board(i)(j) = array(j)
        }
        array.clear()
      }
    case "d" =>
      var array: ArrayBuffer[Int] = new ArrayBuffer[Int]()
      for (i <- 0 to 3) {
        for (j <- 0 to 3) {
          array += b.board(i)(3 - j)
        }
        array = merge(array)
        for (j <- 0 to 3) {
          b.board(i)(3 - j) = array(j)
        }
        array.clear()
      }
    case _ =>
  }

  def generate(m: String): Unit = m match {
    case "w" =>

      var length = 0
      for (j <- 0 to 3) {
        if (b.board(3)(j) == 0) {
          length = length + 1
        }
      }
      val x = Random.nextInt(length)
      var g = 0
      for (j <- 0 to 3) {
        if (b.board(3)(j) == 0) {
          if (g == x) {
            b.board(3)(j) = generateNum()
          }
          g += 1
        }

      }
    case "s" =>
      var length = 0
      for (j <- 0 to 3) {
        if (b.board(0)(j) == 0) {
          length = length + 1
        }
      }
      val x = (new Random).nextInt(length)
      var g = 0

      for (j <- 0 to 3) {
        if (b.board(0)(j) == 0) {

          if (g == x) {
          b.board(0)(j) = generateNum()
        }
        g = g + 1
      }}
    case "a" =>
      var length = 0
      for (j <- 0 to 3) {
        if (b.board(j)(3) == 0) {
          length = length + 1
        }
      }
      val x = (new Random).nextInt(length)
      var g = 0
      for (j <- 0 to 3) {
        if (b.board(j)(3) == 0) {

          if (g == x) {
          b.board(j)(3) = generateNum()
        }
        g = g + 1
      }}
    case "d" =>
      var length = 0
      for (j <- 0 to 3) {
        if (b.board(j)(0) == 0) {
          length = length + 1
        }
      }
      val x = (new Random).nextInt(length)
      var g = 0
      for (j <- 0 to 3) {
        if (b.board(j)(0) == 0) {

          if (g == x) {
          b.board(j)(0) = generateNum()
        }
        g = g + 1
      }}
    case _ =>
      println(">.<")
  }

  def generateNum(): Int = {
    val x = (new Random).nextInt(4)
    if (x == 0) {
      4
    } else {
      2
    }
  }

  def checkVictory(): Unit = {
    var zeroNum = 0
    for (i <- b.board) {
      for (j <- i) {
        if (j == 2048) {
          println("Victory")
        }
        if (j == 0) {
          zeroNum += 1
        }
      }
    }

  }

  def m(str: String): Unit = {
    move(str)
    generate(str)
    display()
  }


}

class board() {
  val board: Array[Array[Int]] = Array.ofDim[Int](4, 4)


  def display(): Unit = {
    for (i <- 0 to 3) {
      for (j <- 0 to 3) {
        printf("%4d", board(i)(j))

      }
      println()
    }
    println("====================")
  }

}

object em {
  def main(args: Array[String]): Unit = {
    val c = new core
    c.init()
    c.display()
    while (true) {
      val action = StdIn.readLine()
      c.m(action)

    }
//
//    c.generate("w")
//    c.display()
//    c.generate("w")
//    c.display()
//   c.generate("w")
//    c.display()
//   c.generate("w")
//    c.display()
//    c.generate("w")
//    c.display()
  }
}