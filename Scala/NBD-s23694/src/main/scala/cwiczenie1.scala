package main.scala

import scala.annotation.tailrec
import scala.collection.convert.ImplicitConversions.`seq AsJavaList`

object cwiczenie1 {

  def main(args: Array[String]): Unit = {
    println("Zadanie 1")
    println()
    println("1a")
    println(forLoop(List("Monday", "Tuesday", "Wedensday", "Thursday", "Friday", "Saturday", "Sunday"), ", "))
    println()
    println("1b")
    println(forLoopRiddle(List("Monday", "Tuesday", "Wedensday", "Thursday", "Friday", "Saturday", "Sunday"), ", "))
    println()
    println("1c")
    println(whileLoop(List("Monday", "Tuesday", "Wedensday", "Thursday", "Friday", "Saturday", "Sunday"), ", "))
    println()
    println()
    println("Zadanie 2")
    println()
    println("2a")
    println(concatRecursion(0, List("Monday", "Tuesday", "Wedensday", "Thursday", "Friday", "Saturday", "Sunday")))
    println()
    println("2b")
    println(concatRecursionReverse(6, List("Monday", "Tuesday", "Wedensday", "Thursday", "Friday", "Saturday", "Sunday")))
    println()
    println("Zadanie 3")
    println(recursionWithTailRec(List("Monday", "Tuesday", "Wedensday", "Thursday", "Friday", "Saturday", "Sunday")))
    println()

    println("Zadanie 4")
    println()
    println("4a")
    println(foldl(List("Monday", "Tuesday", "Wedensday", "Thursday", "Friday", "Saturday", "Sunday")))
    println()
    println("4b")
    println(foldr(List("Monday", "Tuesday", "Wedensday", "Thursday", "Friday", "Saturday", "Sunday")))
    println()
    println("4c")
    println(foldlWithP(List("Monday", "Tuesday", "Wedensday", "Thursday", "Friday", "Saturday", "Sunday")))
    println()

    println("Zadanie 5")
    println()
    println(mapPrices())
    println()
    println("Zadanie 6")
    println()
    println(valuesTuples("String", 6, "abc"))
    println()
    println("Zadanie 7")
    println()
    println(optionReview())
    println()
    println("Zadanie 8")
    println()
    println(listWithoutZeros(List(1, 0, 2, 4, 0, 1)))
    println()
    println("Zadanie 9")
    println()
    println(absoluteValue(List(1, 0, 2, 4, 0, 1)))
    println()
    println("Zadanie 10")
    println()
    println(addOne(List(1, 0, 2, -4, 0, -1)))

  }


  // 1a
  def forLoop(days: List[String], separator: String): String = {

    var result = ""

    for (day <- days) {
      result = result.concat(day).concat(separator)

    }

    result = result.dropRight(2)
    return result
  }


  //1b
  def forLoopRiddle(days: List[String], separator: String): String = {

    var result = ""

    for (day <- days) {
      if (day.toUpperCase.startsWith("P")) {
        result = result.concat(day).concat(separator)
      }
    }

    result = result.dropRight(2)
    return result

  }

  //1c
  def whileLoop(days: List[String], separator: String): String = {

    var result = ""
    var id = 0

    while (id < days.size) {
      result = result.concat(days(id)).concat(separator)
      id += 1
    }

    result = result.dropRight(2)
    return result
  }


  // zad 2 a)
  def concatRecursion(id: Int, days: List[String]): String = {

    val separator: String = ","

    if (id == days.size) {
      return ""
    }

    val newId = id + 1
    var result = days(id) + separator + concatRecursion(newId, days)
    return result

  }

  // zad 2 b)

  def concatRecursionReverse(id: Int, days: List[String]): String = {

    val separator: String = ","

    if (id < 0) {
      return ""
    }

    val newId = id - 1
    val result = days(id) + separator + concatRecursionReverse(newId, days)
    return result
  }


  // Zad 3
  def recursionWithTailRec(days: List[String]): String = {
    @tailrec
    def addingTail(days: List[String], result: String): String = {
      if (days.isEmpty)
        result
      else
        addingTail(days.tail, result + ", " + days.head)
    }

    return addingTail(days.tail, days.head)
  }

  // zad4
  def foldl(days: List[String]): String = {
    return days.fold("") { (sum, day) => {
      sum + day + ", "
    }
    }.dropRight(2)
  }

  def foldr(days: List[String]): String = {
    return days.foldRight("") { (sum, day) => {
      sum + ", " + day
    }
    }.dropRight(2)
  }

  def foldlWithP(days: List[String]): String = {
    return days.fold("") { (sum, day) => {
      if (day.startsWith("P"))
        sum + day + ", "
      else sum

    }
    }.dropRight(2)
  }

  // zadanie 5

  def mapPrices(): Unit = {

    val products = Map("bread" -> 3.40, "butter" -> 4.50, "avocado" -> 7.50)

    val productsLessPrice = products.mapValues { value => 0.9 * value }

    println("Products after discount: " + productsLessPrice.view.force)

  }

  // Zadanie 6

  def valuesTuples(tup: (String, Int, Any)) = {
    println(tup._1)
    println(tup._2)
    println(tup._3)
  }


  //Zadanie 7
  def optionReview(): Unit = {

    val products = Map("bread" -> 3.40, "butter" -> 4.50, "avocado" -> 7.50)

    println(products.get("butter"))
    println()

    println(products.getOrElse("avocado", Double))
    println()
    println(products.getOrElse("Butterr r", Double))

  }

  // Zadanie 8
  def listWithoutZeros(justList: List[Int]): List[Int] = {
    def change(idx: Int, ourList: List[Int]): List[Int] = {
      if (idx == ourList.length)
        return ourList;

      val (list1, list2) = ourList.splitAt(idx)

      // if value == 0
      if (ourList.get(idx) == 0)
        change(idx + 1, list1 ++ list2.tail)
      else
        change(idx + 1, ourList)
    }

    change(0, justList)
  }

  // Zadanie 9
  def addOne(ourList: List[Int]): List[Int] = {
    ourList map (element => element + 1)
  }

  // Zadanie 10 Do poprawy
  def absoluteValue(ourList: List[Int]): List[Int] = {
    val filterList = ourList.filter(element => (element >= -5 && element <= 12)).map(element => element.abs)

    println(filterList)
    return filterList
  }
}
