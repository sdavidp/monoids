val catsV = "2.2.0"

lazy val `monoids` =
  project.in(file("."))
    .settings(commonSettings)
    .settings(
      name := "monoids"
    )

lazy val commonSettings =
  Seq(
    organization := "org.sdp",
    scalaVersion := "2.13.4",

    cancelable in Scope.Global := true,

    libraryDependencies ++= Seq(
      "org.typelevel"     %% "cats-core"           % catsV,
    )
)
