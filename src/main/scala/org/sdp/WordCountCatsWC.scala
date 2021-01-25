package org.sdp

object WordCountCatsWC {
  import cats.Monoid

  case class WC(v: Int) extends AnyVal

  implicit val icbm: Monoid[WC] =
    Monoid.instance[WC](
      WC(0),
      (x,y) => WC(x.v + 1 + y.v)
    )

  def count(s: String): Map[String, WC] = {
    val M = implicitly[Monoid[Map[String, WC]]]

    s.split("\\s+")
      .map(w => Map(w -> WC(1)))
      .fold(M.empty)(M.combine)
  }
}
