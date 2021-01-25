package org.sdp

// During the presentation Chris Davenport showed us how we could generalize this even further.
// With this implementation we would change our invocation of count in Main to the following:
//  val map = count(words)(w => Map(w -> 1))

object WordCountCatsFoldMap {
  import cats.Monoid
  import cats.syntax.all._

  def count [WC: Monoid](s: String)(f: String => WC): WC = {
    s.split("\\s+")
      .toList
      .foldMap(f)
  }
}
