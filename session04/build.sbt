name := "session"

version := "0.1"

scalaVersion := "2.13.3"
//scalaVersion := "2.12.0"

resolvers in Global ++= Seq(
  "Sbt plugins"                   at "https://dl.bintray.com/sbt/sbt-plugin-releases",
  "Maven Central Server"          at "http://repo1.maven.org/maven2",
  "TypeSafe Repository Releases"  at "http://repo.typesafe.com/typesafe/releases/",
  "TypeSafe Repository Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/"
)
libraryDependencies +="com.google.inject" % "guice" % "3.0"
assemblyMergeStrategy in assembly := {
  case PathList("asm-analysis-7.0.jar", xs @ _*) => MergeStrategy.last
  case PathList("asm-commons-7.0.jar", xs @ _*) => MergeStrategy.last
  case PathList("asm-tree-7.0.jar", xs @ _*) => MergeStrategy.last
  case PathList("asm-7.0.jar", xs @ _*) => MergeStrategy.last
  case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
  case _ => MergeStrategy.first
}
