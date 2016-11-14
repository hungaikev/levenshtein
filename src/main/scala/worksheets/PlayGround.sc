object EditDistance {
  def editDistance(str1: String, str2: String): Int = {
    val lengthString1 = str1.length
    val lengthString2 = str2.length

    def min(nums: Int*): Int = nums.min

    // 2 dimensional Array to represent the grid
    val d: Array[Array[Int]] = Array.ofDim(lengthString1 + 1, lengthString2 + 1)

    //This for loop cycles through each array position from left to right then top to bottom and
    // populates them according to the Levenshtein logic
    for (i <- 0 to lengthString1) d(i)(0) = i
    for (j <- 0 to lengthString2) d(0)(j) = j

    for (i <- 1 to lengthString1; j <- 1 to lengthString2) {
      val cost = if (str1(i - 1) == str2(j-1)) 0 else 1

      d(i)(j) = min(
        d(i-1)(j  ) + 1,     // deletion
        d(i  )(j-1) + 1,     // insertion
        d(i-1)(j-1) + cost   // substitution
      )
    }

    d(lengthString1)(lengthString2)
  }

  editDistance("Hungai","Kevin")

  // should work on empty Strings
  assert( editDistance(   "",    "") == 0 )
  assert( editDistance(  "a",    "") == 1 )
  assert( editDistance(   "",   "a") == 1 )
  assert( editDistance("abc",    "") == 3 )
  assert( editDistance(   "", "abc") == 3 )

  //Should work on Equal Strings
  assert( editDistance(   "",    "") == 0 )
  assert( editDistance(  "a",   "a") == 0 )
  assert( editDistance("abc", "abc") == 0 )

  //Should work only where inserts are needed
  assert( editDistance(   "",   "a") == 1 )
  assert( editDistance(  "a",  "ab") == 1 )
  assert( editDistance(  "b",  "ab") == 1 )
  assert( editDistance( "ac", "abc") == 1 )
  assert( editDistance("abcdefg", "xabxcdxxefxgx") == 6 )

  //Should Work where deletes are needed
  assert( editDistance(  "a",    "") == 1 )
  assert( editDistance( "ab",   "a") == 1 )
  assert( editDistance( "ab",   "b") == 1 )
  assert( editDistance("abc",  "ac") == 1 )
  assert( editDistance("xabxcdxxefxgx", "abcdefg") == 6 )

  //Should Work where replacements are needed
  assert( editDistance(  "a",   "b") == 1 )
  assert( editDistance( "ab",  "ac") == 1 )
  assert( editDistance( "ac",  "bc") == 1 )
  assert( editDistance("abc", "axc") == 1 )

  //Should work where many operations are needed
  assert( editDistance("example", "samples") == 3 )
  assert( editDistance("sturgeon", "urgently") == 6 )
  assert( editDistance("levenshtein", "frankenstein") == 6 )
  assert( editDistance("distance", "difference") == 5 )
  assert( editDistance("java was neat", "scala is great") == 7 )




}