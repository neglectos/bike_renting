package domain

class BikeRepository {

  def rentBike(bike: Bike): Bike = {
    bike.state = "rented"
    println(s"$bike is rented - FROM DOMAIN")
    bike
  }

  def returnBike(bike: Bike): Unit = {
    bike.state = "free"
    println(s"$bike is returned successfully - FROM DOMAIN")
  }

}




