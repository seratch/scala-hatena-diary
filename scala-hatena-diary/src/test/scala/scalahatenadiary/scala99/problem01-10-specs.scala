import org.specs.Specification
import scalahatenadiary.scala99._

object P01Spec extends Specification {
  "P01_FindTheLastElementOfAList.last(List(1, 1, 2, 3, 5, 8)) " should {
    "return 8 using built-in method" in {
      P01_FindTheLastElementOfAList.last1(List(1, 1, 2, 3, 5, 8)) mustEqual 8
    }
    "return 8" in {
      P01_FindTheLastElementOfAList.last2(List(1, 1, 2, 3, 5, 8)) mustEqual 8
    }
  }
}

object P02Spec extends Specification {
  "P02_FindTheLastButOneElementOfAList.penultimate(List(1, 1, 2, 3, 5, 8)) " should {
    "return 5" in {
      P02_FindTheLastButOneElementOfAList.penultimate(List(1, 1, 2, 3, 5, 8)) mustEqual 5
    }
  }
}

object P03Spec extends Specification {
  "P03_FindTheNthElementOfAList.getNthElement(2,List(1, 1, 2, 3, 5, 8)) " should {
    "return 2" in {
      P03_FindTheNthElementOfAList.getNthElement(2, List(1, 1, 2, 3, 5, 8)) mustEqual 2
    }
  }
  "P03_FindTheNthElementOfAList.getNthElement2(2,List(1, 1, 2, 3, 5, 8)) " should {
    "return 2" in {
      P03_FindTheNthElementOfAList.getNthElement2(2, List(1, 1, 2, 3, 5, 8)) mustEqual 2
    }
  }
}

object P04Spec extends Specification {
  "P04_FindTheNumberOfElementsOfAList.length(List(1, 1, 2, 3, 5, 8)) " should {
    "return 6" in {
      P04_FindTheNumberOfElementsOfAList.length(List(1, 1, 2, 3, 5, 8)) mustEqual 6
    }
  }
  "P04_FindTheNumberOfElementsOfAList.length2(List(1, 1, 2, 3, 5, 8)) " should {
    "return 6" in {
      P04_FindTheNumberOfElementsOfAList.length2(List(1, 1, 2, 3, 5, 8)) mustEqual 6
    }
  }
}

object P05Spec extends Specification {
  "P05_ReverseAList.reverse(List(1, 1, 2, 3, 5, 8)) " should {
    "return List(8, 5, 3, 2, 1, 1)" in {
      P05_ReverseAList.reverse(List(1, 1, 2, 3, 5, 8)) mustEqual List(8, 5, 3, 2, 1, 1)
    }
  }
  "P05_ReverseAList.reverse2(List(1, 1, 2, 3, 5, 8)) " should {
    "return List(8, 5, 3, 2, 1, 1)" in {
      P05_ReverseAList.reverse2(List(1, 1, 2, 3, 5, 8)) mustEqual List(8, 5, 3, 2, 1, 1)
    }
  }
}
