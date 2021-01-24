package org.sdp

import scala.collection.immutable.TreeMap

object Main {
  val words: String =
    """I thought a thought
      |but the thought I thought
      |wasn’t the thought I thought I thought
      |if the thought I thought I thought
      |had been the thought I thought
      |I wouldn’t have thought I thought
      |""".stripMargin

  def pretty(m: Map[String, Int]): String =
    TreeMap.from(m).mkString("\n")

  def main(args: Array[String]): Unit = {
    import WordCountBaeldung._

    val map = count(words)

    println(pretty(map))
  }
}
