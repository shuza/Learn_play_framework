name := "play-java"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  jdbc,
  javaJdbc,
  "mysql" % "mysql-connector-java" % "5.1.36",
  "com.eclipsesource.minimal-json" % "minimal-json" % "0.9.4"
)
