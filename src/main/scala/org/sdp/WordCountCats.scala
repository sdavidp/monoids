package org.sdp

object WordCountCats {
  import cats.Monoid

  def count(s: String)(implicit M: Monoid[Map[String, Int]]): Map[String, Int] =
    s.split("\\s+")
      .map(w => Map(w -> 1))
      .fold(M.empty)(M.combine)
}
