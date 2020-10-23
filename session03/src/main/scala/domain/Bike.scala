package domain

sealed class Bike{
  var price: Int = 100
  var state: String = "free"
}

case class RoadBike(color: String= "black") extends Bike
case class ElectricBike(color: String = "white") extends Bike{
  price = 250
}


