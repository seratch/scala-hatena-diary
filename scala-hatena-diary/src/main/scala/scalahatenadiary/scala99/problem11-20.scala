/**
 * http://aperiodic.net/phil/scala/s-99/
 */
package scalahatenadiary.scala99

/**
 * Modified run-length encoding.
 *
 * Modify the result of problem P10 in such a way
 * that if an element has no duplicates it is simply copied into the result list.
 * Only elements with duplicates are transferred as (N, E) terms.
 *
 * encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * // -> List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
 */
object P11_ModifiedRunLengthEncoding extends Application {

  def encodeModified(list: List[Any]): List[Any] = {
    def _encodeModified(accumulator: List[Any], rest: List[Any]): List[Any] = rest match {
      case head :: tail => rest.takeWhile(_ == head).length match {
        case 1 => _encodeModified(head :: accumulator, tail.dropWhile(_ == head))
        case len => _encodeModified(Pair(len, head) :: accumulator, tail.dropWhile(_ == head))
      }
      case Nil => accumulator.reverse
    }
    _encodeModified(Nil, list)
  }

  import P10_RunLengthEncodingOfAList._

  def encodeModified2(list: List[Any]): List[Any] = encode(list) map {
    each => each match {
      case (1, value) => value
      case _ => each
    }
  }

  def encodedModified3TypeSafe[T](list: List[T]): List[Either[T, Pair[Int, T]]] = {
    encode(list) map {
      each => each match {
        case (1, value) => Left(value)
        case _ => Right(each)
      }
    }
  }

}

/**
 * Decode a run-length encoded list.
 *
 * Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
 *
 * decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
 * // -> List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
 */
object P12_DecodeARunLengthEncodedList extends Application {

  def decode[T](list: List[Pair[Int, T]]): List[T] = {
    def _decode(accumulator: List[T], rest: List[Pair[Int, T]]): List[T] = {
      rest match {
        case head :: tail => head match {
          case (len, value: T) => {
            _decode((for (i <- 1 to len) yield value).toList ::: accumulator, tail)
          }
        }
        case _ => accumulator.reverse
      }
    }
    _decode(Nil, list)
  }

  def decode2[T](list: List[Pair[Int, T]]): List[T] = list flatMap {
    // List#make has been deprecated
    each => List.fill(each._1)(each._2)
  }

}