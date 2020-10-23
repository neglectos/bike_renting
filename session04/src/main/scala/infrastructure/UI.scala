package infrastructure


import api.ApiBinding
import domain.{Bike, DomainBinding, ElectricBike, RoadBike, User}
import com.google.inject.Guice

object UI extends App {
  // retrieve the injector
  val injector = Guice.createInjector(new ApiBinding, new DomainBinding)
  var infra = injector.getInstance(classOf[Infra]) //get UserService object
  val manageUser = infra.manageUser
  val manageBike = infra.manageBike

  // dummy interactive script
  var choice: String = _
  var continue = "y"
  var user: User = _
  var bike: Bike = _
  while(continue == "y" || continue == "Y") {
    println("Which task you want to do:")
    println("To add a user, type 1")
    println("To login a user, type 2")
    println("To logoff a user, type 3")
    println("To rent a bike, type 4")
    choice = scala.io.StdIn.readLine()

    def rentBike: Bike = {
      println("Which type of Bike you would like. (1) RoadBike, (2) ElectricalBike or (3) doesn't matter")
      scala.io.StdIn.readLine() match {
        case "1" => manageBike.rentBike(user, new RoadBike())
        case "2" => manageBike.rentBike(user, new ElectricBike())
        case _ => manageBike.rentBike(user, new ElectricBike())
      }
    }

    try {
      choice match {
        case "1" => user = addUser
        case "2" => user = manageUser.loginUser(user)
        case "3" => manageUser.logoffUser(user)
        case "4" => bike = rentBike
        case _ => println("something went wrong.")
      }
    }
    catch {
      case e: Exception => println("Something went wrong")
    }
    println("continue? Y/N ")
    continue = scala.io.StdIn.readLine()
  }

    def addUser: User = {
      println("pleas type name")
      var name =scala.io.StdIn.readLine()
      println("pleas type balance")
      var balance = scala.io.StdIn.readLine()
      manageUser.createUser(name, balance.toInt)
    }

}



