package scalahatenadiary.helloworld

import java.util.Date
import xml.{NodeSeq, Elem}

object HelloWorldByMainMethod {
  def main(args: Array[String]) = println("Hello World!")
}

object HelloWorldByApplication extends Application {
  println("Hello World!")
}

object HelloWorldWithMethod extends Application {

  def hello(str: String) = println("Hello " + str + "!")

  hello("World")

  def helloWorld(str: String = "World") = println("Hello " + str + "!")

  helloWorld()
  helloWorld("WORLD")
}

object HelloWorldWithFunction extends Application {

  val helloFunc1: (String) => Unit = {
    str => println("Hello " + str + "!")
  }

  helloFunc1("World")
  helloFunc1.apply("World")

  def sayHelloTo(str: String) = println("Hello " + str + "!")

  val helloFunc2 = sayHelloTo _
  helloFunc2("World")
  helloFunc2.apply("World")
}

object HelloWorldWithPartiallyAppliedFunction extends Application {

  def displayCurrying(hello: String)(world: String) = {
    println(hello + " " + world + "!")
  }

  val displayHello = displayCurrying("Hello") _
  displayHello("World")
}

object HelloWorldWithCallByName extends Application {

  def message(): String = {
    print("Hello ")
    "World!"
  }

  def displayHelloWorld1(message: => String) = {
    print("*** ")
    print(message)
    println(" ***")
  }

  displayHelloWorld1(message())

  def displayHelloWorld2(message: () => String) = {
    print("*** ")
    print(message())
    println(" ***")
  }

  val messageFunc = message _
  displayHelloWorld2(messageFunc)
}

object HelloWorldWithLazyVal extends Application {
  lazy val lazyWorld = "Hello World! (" + new Date + ")";
  println("Waiting...   (" + new Date + ")")
  Thread.sleep(2000L)
  println(lazyWorld)
}

object HelloWorldWithClosure extends Application {
  val prefix = "Hello "
  var suffix = "!"
  val helloClosure: (String) => Unit = {
    str => println(prefix + str + suffix)
  }
  helloClosure("World")
  suffix = "!!!"
  helloClosure("World")
}

object HelloWorldWithClass extends Application {

  class HelloWorld {
    def display() = println("Hello World!")
  }

  val hw = new HelloWorld
  hw.display()
}

object HelloWorldWithCaseClass extends Application {

  val English = "English"
  val Japanese = "Japanese"

  case class HelloWorldIn(lang: String)

  def printHelloWorld(hw: HelloWorldIn) = {
    hw match {
      case HelloWorldIn(English) => println("Hello World!")
      case HelloWorldIn(Japanese) => println("こんにちは世界!")
      case _ => throw new IllegalArgumentException("unknown case class : " + hw)
    }
  }

  printHelloWorld(HelloWorldIn(English))
  printHelloWorld(HelloWorldIn(Japanese))
}

trait HelloWorldTrait {
  def display() = println("Hello World!")
}

object HelloWorldWithTrait extends Application with HelloWorldTrait {
  display()
}

object HelloWorldWithList extends Application {
  val charList = List("H", "e", "l", "l", "o", " ", "W", "o", "r", "l", "d", "!", "\n")

  // foreach
  charList foreach (print)

  // generator
  for (c <- charList) print(c)

  // recursive call
  def recursiveDisplay(list: List[String]): Unit = {
    list match {
      case h :: Nil => print(h)
      case h :: t => {
        print(h)
        recursiveDisplay(t)
      }
      case _ =>
    }
  }

  recursiveDisplay(charList)
}

object HelloWorldWithImplicitParameters extends Application {

  object HelloWorld {
    def display(hello: String)(implicit world: World) = println(hello + " " + world.name + "!")
  }

  case class World(val name:String)

  implicit val WORLD_VAL = World("Scala World")

  HelloWorld.display("Hello")
  HelloWorld.display("Hello")(World("Groovy World"))

}

object HelloWorldWithImplicitConversions extends Application {

  case class Printer(val value: String) {
    def display() = println(value)
  }

  implicit def toPrinter(str: String): Printer = Printer(str)

  "Hello World!".display()
}

object HelloWorldWithXML extends Application {
  val xml: Elem =
    <items>
      <item>Hello World!</item>
    </items>
  val node: NodeSeq = xml \ "item"
  println(node.text)
}

object HelloWorldWithActor extends Application {

  import actors.Actor

  class HelloActor extends Actor {
    override def act() = {
      loop {
        react {
          case (str: String, wait: Long) => {
            Thread.sleep(wait)
            println("Hello " + str + "!")
          }
          case _ => println("unknown message")
        }
      }
    }
  }

  val hello1 = new HelloActor
  val hello2 = new HelloActor
  hello1.start()
  hello2.start()
  hello1 ! ("World", 200L)
  hello2 ! ("WORLD1", 100L)
  hello2 ! ("WORLD2", 300L)
  Thread.sleep(2000L)
  System.exit(0)
}



