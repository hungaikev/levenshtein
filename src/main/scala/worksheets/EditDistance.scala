package worksheets


/**
  * Created by hungai on 11/13/16.
  *
  * Declare a Singleton Object EditDistance having a single method
  *
  * editDistance(str1,str2):Int
  *
  *
  */

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
        d(i-1)(j  ) + 1,     // deleting a character
        d(i  )(j-1) + 1,     // insertion a character
        d(i-1)(j-1) + cost   // replacing a character
      )
    }

    d(lengthString1)(lengthString2)
  }


}
