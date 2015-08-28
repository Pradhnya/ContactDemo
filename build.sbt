name := "ContactDemo"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  jdbc,
  javaJpa,
  "mysql" % "mysql-connector-java" % "5.1.34",
  "com.typesafe.play" %% "play-json" % "2.3.4",
  "com.googlecode.json-simple" % "json-simple" % "1.1",
  "com.sun.jersey" % "jersey-server" % "1.19",
  "com.sun.jersey" % "jersey-client" % "1.19",
  "com.sun.jersey" % "jersey-core" % "1.19",
  "com.google.code.gson" % "gson" % "2.2.4"
)

resolvers ++= Seq(
  "Maven2" at "http://repo1.maven.org/maven2/",
  "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"
)

play.Project.playJavaSettings
