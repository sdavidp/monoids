package org.sdp

// From https://www.baeldung.com/scala/monoids-semigroups

object WordCountBaeldung {

  case class WordCount(word: String, count: Int)

  def count(s: String): Map[String, Int] =
    s.split("\\s+")
      .map(x => WordCount(x, 1))
      .groupBy(w => w.word)
      .map(x => (x._1 -> x._2.foldLeft(0)((a, c) => c.count + a)))
      .toMap
}
