package domain

trait Domain {
  def userRepository: UserRepository
  def bikeRepository: BikeRepository
}
