package infrastructure


import api.Api
import domain.{Domain, ElectricBike, RoadBike}

object UI extends Domain with Api with Infrastructure with App{

    val user  = manageUser.createUser("Ahmed", 9000)  // create a user
    val bike  = manageBike.rentBike(user, new RoadBike()) // Try to rent  bike
    println("bike", bike.state) // show bike availability: bike should be "rent"
    manageUser.logoffUser(user) // Logging off the user
    var bike2  = manageBike.rentBike(user, new ElectricBike()) // try to rent a bike
    println("bike2", bike2.state) // bike's state should be: "free" since the user not logged in
    manageUser.loginUser(user) // logging in the user
    bike2  = manageBike.rentBike(user, new ElectricBike()) // try to rent the bike again
    println("bike2", bike2.state) // the bike should be rented
}



