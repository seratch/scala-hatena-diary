package scalahatenadiary.scala99

/**
 * Find the last element of a list.
 * last(List(1, 1, 2, 3, 5, 8)) // => 8
 */
object P01_FindTheLastElementOfAList {

  //  def last1(list: List[Int]): Int = list.last
  def last1[T](list: List[T]): T = list.last

  //  def last2(list: List[Int]): Int = {
  def last2[T](list: List[T]): T = {
    list match {
      case head :: Nil => head
      case _ :: tail => last2(tail)
      case _ => throw new NoSuchElementException
    }
  }

}

/**
 * Find the last but one element of a list.
 * penultimate(List(1, 1, 2, 3, 5, 8)) // => 5
 */
object P02_FindTheLastButOneElementOfAList {

  def penultimate[T](list: List[T]): T = {
    list match {
      case a :: b :: Nil => a
      case _ :: tail => penultimate(tail)
      case _ => throw new NoSuchElementException
    }
  }

}

/**
 * Find the K(0-n)th element of a list.
 * By convention, the first element in the list is element 0.
 * nth(2, List(1, 1, 2, 3, 5, 8)) // => 2
 */
object P03_FindTheNthElementOfAList {

  //  def getNthElement[T](n: Int, list: List[T]): T = list.apply(n)
  def getNthElement[T](n: Int, list: List[T]): T = list(n)

  def getNthElement2[T](n: Int, list: List[T]): T = {
    (n, list) match {
      case (0, head :: _) => head
      case (n, _ :: tail) => getNthElement2(n - 1, tail)
      case (_, Nil) => throw new NoSuchElementException
    }
  }

}

/**
 * Find the number of elements of a list.
 * length(List(1, 1, 2, 3, 5, 8)) // => 6
 */
object P04_FindTheNumberOfElementsOfAList {

  def length[T](list: List[T]): Int = list.size

  def length2[T](list: List[T]): Int = {
    def _length(accumulator: Int, tail: List[T]): Int = {
      tail match {
        case head :: Nil => accumulator + 1
        case _ :: tail => _length(accumulator + 1, tail)
        case _ => throw new NoSuchElementException
      }
    }
    _length(0, list)
  }

}

/**
 * Reverse a list.
 * reverse(List(1, 1, 2, 3, 5, 8)) // => List(8, 5, 3, 2, 1, 1)
 */
object P05_ReverseAList {

  def reverse[T](list: List[T]): List[T] = list.reverse

  def reverse2[T](list: List[T]): List[T] = {
    def _reverse(accumulator: List[T], rest: List[T]): List[T] = {
      rest match {
        case (head :: Nil) => head :: accumulator
        case (head :: tail) => _reverse(head :: accumulator, tail)
        case _ => throw new NoSuchElementException
      }
    }
    _reverse(Nil, list)
  }

}