package scalahatenadiary.scala99

import org.specs.Specification

object P11Spec extends Specification {
  "P11.encodeModified(List[Any]) " should {
    "run expectedly" in {
      P11_ModifiedRunLengthEncoding.encodeModified(
        List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      ) mustEqual List((4, 'a), 'b, (2, 'c), (2, 'a), 'd, (4, 'e))
    }
  }
  "P11.encodeModified2(List[Any]) " should {
    "run expectedly" in {
      P11_ModifiedRunLengthEncoding.encodeModified2(
        List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      ) mustEqual List((4, 'a), 'b, (2, 'c), (2, 'a), 'd, (4, 'e))
    }
  }
  "P11.encodeModified3TypeSafe(List[Any]) " should {
    "run expectedly" in {
      P11_ModifiedRunLengthEncoding.encodedModified3TypeSafe(
        List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      ) mustEqual List(Right(4, 'a), Left('b), Right(2, 'c), Right(2, 'a), Left('d), Right(4, 'e))
    }
  }
}

object P12Spec extends Specification {
  "P12.decode(List[Int,T]) " should {
    "run expectedly" in {
      P12_DecodeARunLengthEncodedList.decode(
        List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
      ) mustEqual List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    }
  }
  "P12.decode2(List[Int,T]) " should {
    "run expectedly" in {
      P12_DecodeARunLengthEncodedList.decode2(
        List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
      ) mustEqual List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    }
  }
}
