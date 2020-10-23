package api

import com.google.inject.Inject
import domain.{Bike, BikeTrait, User, UserTrait}

trait ManageBikeTrait{
  def rentBike(user: User, bike: Bike): Bike
  def returnBike(user: User, bike:Bike)
}

class ManageBike @Inject()(userRepository: UserTrait, bikeRepository: BikeTrait) extends ManageBikeTrait {
  def rentBike(user: User, bike: Bike): Bike = {
      println(s"${user.name} wants to rent a $bike")
      if(bike.state == "free" & user.state == true){
        ManageUser(userRepository).reduceBalance(user, bike.price)
        bikeRepository.rentBike(bike)
      }
    else{
        print("The operation could not happen")
        bike
      }
  }

  def returnBike(user: User, bike:Bike): Unit = {
    ManageUser(userRepository).addBalance(user, bike.price)
    bikeRepository.returnBike(bike)
  }
}