/**
 * http://aperiodic.net/phil/scala/s-99/
 */
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

/**
 * Find out whether a list is a palindrome.
 * isPalindrome(List(1, 2, 3, 2, 1)) // => true
 */
object P06_FindOutWhehterAListIsAPalindrome {

  def isPalindrome[T](list: List[T]): Boolean = list == list.reverse

}

/**
 * Flatten a nested list structure.
 * flatten(List(List(1, 1), 2, List(3, List(5, 8)))) // => List(1, 1, 2, 3, 5, 8)
 */
object P07_FlattenANestedListStructure {
  //def flatten(list: List[Any]): List[Any] = list.flatMap {
  //  case l: List[Any] => flatten(l)
  //  case e => List(e)
  //}
  def flatten(list: List[_]): List[Any] = list.flatMap {
    case l: List[_] => flatten(l)
    case e => List(e)
  }

}

/**
 * Eliminate consecutive duplicates of list elements.
 * If a list contains repeated elements they should be replaced with a single copy of the element.
 * The order of the elements should not be changed.
 * compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) // =>  List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
 */
object P08_EliminateConsecutiveDuplicatesOfListElements {

  def compress[T](list: List[T]): List[T] = {
    //def _compress(accumulator: List[T], list: List[T]): List[T] = {
    //  list match {
    //    case prev :: current :: tail => {
    //      if (accumulator == Nil || prev != current) {
    //        _compress(accumulator ::: List(current), current :: tail)
    //      } else {
    //        _compress(accumulator, current :: tail)
    //      }
    //    }
    //    case _ => accumulator
    //  }
    //}
    //_compress(Nil, list)
    def _compress(accumulator: List[T], list: List[T]): List[T] = list match {
      case head :: tail => _compress(head :: accumulator, tail.dropWhile(_ == head))
      case Nil => accumulator.reverse
    }
    _compress(Nil, list)
  }

}

/**
 * Pack consecutive duplicates of list elements into sublists.
 * If a list contains repeated elements they should be placed in separate sublists.
 * pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * // => List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
 */
object P09_PackConsecutiveDuplicatesOfListElementsIntoSubLists {

  def pack[T](list: List[T]): List[List[T]] = {
    def _pack(accumulator: List[List[T]], list: List[T]): List[List[T]] = list match {
      case head :: tail => _pack(list.takeWhile(_ == head) :: accumulator, tail.dropWhile(_ == head))
      case Nil => accumulator.reverse
    }
    _pack(Nil, list)
  }
}

/**
 * Run-length encoding of a list.
 * Use the result of problem P09 to implement the so-called run-length encoding data compression method.
 * Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
 * encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * // => List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
 */
object P10_RunLengthEncodingOfAList {

  import P09_PackConsecutiveDuplicatesOfListElementsIntoSubLists._

  def encode[T](list: List[T]): List[Pair[Int, T]] = {
    // pack(list) map (elem => (elem.length, elem.apply(0)))
    pack(list) map (elem => (elem.length, elem.head))
  }

  def encode2[T](list: List[T]): List[Pair[Int, T]] = {
    def _encode(accumulator: List[Pair[Int, T]], list: List[T]): List[Pair[Int, T]] = list match {
      case head :: tail => _encode((list.takeWhile(_ == head).length, head) :: accumulator, tail.dropWhile(_ == head))
      case Nil => accumulator.reverse
    }
    _encode(Nil, list)
  }

}
