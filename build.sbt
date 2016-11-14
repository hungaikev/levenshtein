name := "levenshtein"

version := "1.0"

scalaVersion := "2.12.0"

val scalaTest = "3.0.0"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "3.8.6" % "test",
  "org.scalatest" %% "scalatest" % scalaTest % "test"
)
    