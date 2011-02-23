import org.specs.Specification
import scalahatenadiary.scala99._

object P01Spec extends Specification {
  "P01.last(List[T]) " should {
    "run expectedly when using built-in method" in {
      P01_FindTheLastElementOfAList.last1(List(1, 1, 2, 3, 5, 8)) mustEqual 8
    }
    "run expectedly" in {
      P01_FindTheLastElementOfAList.last2(List(1, 1, 2, 3, 5, 8)) mustEqual 8
    }
  }
}

object P02Spec extends Specification {
  "P02.penultimate(List[T]) " should {
    "run expectedly" in {
      P02_FindTheLastButOneElementOfAList.penultimate(List(1, 1, 2, 3, 5, 8)) mustEqual 5
    }
  }
}

object P03Spec extends Specification {
  "P03.getNthElement(Int,List[T]) " should {
    "run expectedly" in {
      P03_FindTheNthElementOfAList.getNthElement(2, List(1, 1, 2, 3, 5, 8)) mustEqual 2
    }
  }
  "P03.getNthElement2(Int,List[T]) " should {
    "run expectedly" in {
      P03_FindTheNthElementOfAList.getNthElement2(2, List(1, 1, 2, 3, 5, 8)) mustEqual 2
    }
  }
}

object P04Spec extends Specification {
  "P04.length(List[T]) " should {
    "run expectedly" in {
      P04_FindTheNumberOfElementsOfAList.length(List(1, 1, 2, 3, 5, 8)) mustEqual 6
    }
  }
  "P04.length2(List[T]) " should {
    "run expectedly" in {
      P04_FindTheNumberOfElementsOfAList.length2(List(1, 1, 2, 3, 5, 8)) mustEqual 6
    }
  }
}

object P05Spec extends Specification {
  "P05.reverse(List[T]) " should {
    "run expectedly" in {
      P05_ReverseAList.reverse(List(1, 1, 2, 3, 5, 8)) mustEqual List(8, 5, 3, 2, 1, 1)
    }
  }
  "P05.reverse2(List[T]) " should {
    "run expectedly" in {
      P05_ReverseAList.reverse2(List(1, 1, 2, 3, 5, 8)) mustEqual List(8, 5, 3, 2, 1, 1)
    }
  }
}

object P06Spec extends Specification {
  "P06.isPalindrome(List[T]) " should {
    "run expectedly" in {
      P06_FindOutWhehterAListIsAPalindrome.isPalindrome(List(1, 2, 3, 2, 1)) mustEqual true
    }
  }
  "P06.isPalindrome(List[T]) " should {
    "run expectedly" in {
      P06_FindOutWhehterAListIsAPalindrome.isPalindrome(List(1, 2, 3, 2, 2)) mustEqual false
    }
  }
}

object P07Spec extends Specification {
  "P07.flatten(List[T]) " should {
    "run expectedly" in {
      P07_FlattenANestedListStructure.flatten(List(List(1, 1), 2, List(3, List(5, 8)))) mustEqual List(1, 1, 2, 3, 5, 8)
    }
  }
}

object P08Spec extends Specification {
  "P08.compress(List[T])" should {
    "run expectedly" in {
      P08_EliminateConsecutiveDuplicatesOfListElements.compress(
        List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      ) mustEqual List('a, 'b, 'c, 'a, 'd, 'e)
    }
  }
}

object P09Spec extends Specification {
  "P09.pack(List[T])" should {
    "run expectedly" in {
      P09_PackConsecutiveDuplicatesOfListElementsIntoSubLists.pack(
        List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      ) mustEqual List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
    }
    "run expectedly with empty List" in {
      P09_PackConsecutiveDuplicatesOfListElementsIntoSubLists.pack(Nil) mustEqual Nil
    }
  }
}

object P10Spec extends Specification {
  "P10.encode(List[T])" should {
    "run expectedly" in {
      P10_RunLengthEncodingOfAList.encode(
        List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      ) mustEqual List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    }
  }
  "P10.encode2(List[T])" should {
    "run expectedly" in {
      P10_RunLengthEncodingOfAList.encode2(
        List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      ) mustEqual List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    }
  }
}
