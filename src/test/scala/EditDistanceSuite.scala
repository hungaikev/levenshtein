import org.specs2.mutable.Specification
import worksheets.EditDistance.editDistance
/**
  * Created by hungai on 11/13/16.
  */
class EditDistanceSuite extends Specification {
  "Edit Distance" should {
    "work on empty Strings" in {
      editDistance(   "",    "") === 0
      editDistance(  "a",    "") === 1
      editDistance(   "",   "a") === 1
      editDistance("abc",    "") === 3
      editDistance(   "", "abc") === 3

    }

    "work on equal strings" in {
       editDistance(   "",    "") === 0
       editDistance(  "a",   "a") === 0
       editDistance("abc", "abc") === 0
    }
    "work only where inserts are needed" in {
      editDistance(   "",   "a") === 1
      editDistance(  "a",  "ab") === 1
      editDistance(  "b",  "ab") === 1
      editDistance( "ac", "abc") === 1
      editDistance("abcdefg", "xabxcdxxefxgx") === 6
    }
    "work where deletes are needed" in {
      editDistance(  "a",    "") === 1
      editDistance( "ab",   "a") === 1
      editDistance( "ab",   "b") === 1
      editDistance("abc",  "ac") === 1
      editDistance("xabxcdxxefxgx", "abcdefg") === 6
    }
    "work where replacements are needed" in {
      editDistance(  "a",   "b") === 1
      editDistance( "ab",  "ac") === 1
      editDistance( "ac",  "bc") === 1
      editDistance("abc", "axc") === 1
    }
    "work where many operations are needed" in {
        editDistance("example", "samples") === 3
        editDistance("sturgeon", "urgently") === 6
        editDistance("levenshtein", "frankenstein") === 6
        editDistance("distance", "difference") === 5
        editDistance("java was neat", "scala is great") === 7
    }
  }

}
