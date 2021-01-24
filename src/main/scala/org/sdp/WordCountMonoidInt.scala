package org.sdp

object WordCountMonoidInt {
  import MapMonoidWithMonadicV._

  implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
    override def empty: Int = 0
    override def combine(x: Int, y: Int): Int = x + y
  }

  private val wordsMonoid = mapMonoid[String, Int]

  def count(s: String): Map[String, Int] =
    s.split("\\s+")
      .map(w => Map(w -> 1))
      .fold(wordsMonoid.empty)(wordsMonoid.combine)
}
