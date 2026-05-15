name := "play-error-handling"

version := "1.0.0"

scalaVersion := "3.8.2"

libraryDependencies += guice
libraryDependencies += javaJpa
libraryDependencies += "org.projectlombok" % "lombok" % "1.18.46" % "provided"
libraryDependencies += "com.mysql" % "mysql-connector-j" % "9.7.0"
libraryDependencies += "org.hibernate.orm" % "hibernate-core" % "7.3.4.Final"

Compile / javacOptions ++= Seq("-proc:full")

lazy val root = (project in file(".")).enablePlugins(PlayJava)