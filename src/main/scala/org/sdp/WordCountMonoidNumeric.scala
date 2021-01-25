package org.sdp

object WordCountMonoidNumeric {
  import MapMonoidWithNumericV._

  private val wordsMonoid = mapMonoid[String, Int]

  def count(s: String): Map[String, Int] =
    s.split("\\s+")
      .map(w => Map(w -> 1))
      .fold(wordsMonoid.zero)(wordsMonoid.op)
}
