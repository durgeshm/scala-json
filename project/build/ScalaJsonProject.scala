import sbt._
import com.twitter.sbt._

class ScalaJsonProject(info: ProjectInfo) extends StandardProject(info) with SubversionPublisher {
    
  val localMaven = Resolver.file("Local Maven repository", new java.io.File(Path.userHome+"/.m2/repository"))
  val publishTo = localMaven 
  
  val specs = "org.scala-tools.testing" %% "specs" % "1.6.9" % "test"

  override def subversionRepository = Some("http://svn.local.twitter.com/maven-public/")

  // override def disableCrossPaths = false

  override def compileOptions = super.compileOptions ++ Seq(Unchecked) ++
    compileOptions("-encoding", "utf8")

  override def pomExtra =
    <licenses>
      <license>
        <name>Apache 2</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
        <distribution>repo</distribution>
      </license>
      <license>
        <name>Scala License</name>
        <url>http://www.scala-lang.org/node/146</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
}
