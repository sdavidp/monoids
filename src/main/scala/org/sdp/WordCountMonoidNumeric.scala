package org.sdp

object WordCountMonoidNumeric {

  private val wordsMonoid = MapMonoidWithNumericV.mapMonoid[String, Int]

  def count(s: String): Map[String, Int] =
    s.split("\\s+")
      .map(w => Map(w -> 1))
      .fold(wordsMonoid.zero)(wordsMonoid.op)
}
