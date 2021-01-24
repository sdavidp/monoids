package org.sdp

// Loosely based on https://www.baeldung.com/scala/monoids-semigroups

object MapMonoidWithNumericV {
  trait Semigroup[A] {
    def op(x: A, y: A): A  // removed call by-name
  }
  trait Monoid[A] extends Semigroup[A] {
    def zero: A
  }

  implicit def mapMonoid[K, V](implicit N: Numeric[V]): Monoid[Map[K, V]] =
    new Monoid[Map[K, V]] {
      override def zero: Map[K, V] = Map()

      override def op(l: Map[K, V], r: Map[K, V]): Map[K, V] =
        l.keySet
          .union(r.keySet)
          .map(k => k -> N.plus(          // l(k) + r(k)
            l.getOrElse(k, N.zero),
            r.getOrElse(k, N.zero))
          )
          .toMap
    }
}
