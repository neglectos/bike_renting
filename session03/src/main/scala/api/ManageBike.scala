package api

import domain.{Bike, BikeRepository, User, UserRepository}


class ManageBike(userRepository: UserRepository, bikeRepository: BikeRepository) {
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