package org.sdp

// Loosely based on https://www.baeldung.com/scala/monoids-semigroups

object MapMonoidWithMonadicV {

  trait Semigroup[A] {
    def combine(x: A, y: A): A  // removed call by-name
  }

  trait Monoid[A] extends Semigroup[A] {
    def empty: A
  }

  implicit def mapMonoid[K, V](implicit M: Monoid[V]): Monoid[Map[K, V]] =
    new Monoid[Map[K, V]] {
      override def empty: Map[K, V] = Map()

      override def combine(l: Map[K, V], r: Map[K, V]): Map[K, V] =
        l.keySet.union(r.keySet)
          .map(k => {
            k -> M.combine(
              l.getOrElse(k, M.empty),
              r.getOrElse(k, M.empty))
          }).toMap
    }
}
