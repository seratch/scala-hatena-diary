package scalahatenadiary.withjava

class Company {

  var workers: List[Person] = Nil
  var specialists: List[Specialist] = Nil

  def employ(newcomer: Person): Unit = {
    workers = (newcomer :: workers).reverse
    newcomer match {
      case Specialist(name) => {
        specialists = Specialist(name) :: specialists
      }
      case _ =>
    }
  }

  def fire(firee: Person): Unit = {
    workers = workers.filter(_.name != firee.name)
    specialists = specialists.filter(_.name != firee.name)
  }

  def getWorkers(): List[Person] = this.workers

  def getSpecialists(): List[Specialist] = this.specialists

  def displayWorkers(): Unit = {
    print("All: ")
    getWorkers foreach {
      worker => print(worker.name + " ")
    }
    println("")
  }

  def displaySpecialists(): Unit = {
    print("Specialists: ")
    getSpecialists foreach {
      specialist => print(specialist.name + " ")
    }
    println("")
  }

}

case class Specialist(override val name: String) extends Person(name)

object Main extends Application {

  val co = new Company
  val taro = Specialist("Taro")
  val jiro = new Person("Jiro")
  val saburo = new Person("Saburo")

  co.employ(taro)
  co.employ(jiro)
  co.displayWorkers()
  co.displaySpecialists()

  co.fire(taro)
  co.employ(saburo)
  co.displayWorkers()
  co.displaySpecialists()

}