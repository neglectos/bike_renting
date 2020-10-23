package infrastructure


import api.{Api, ManageBike, ManageUser}
import domain.{BikeRepository, Domain, UserRepository}

trait Infrastructure {
  this: Api with Domain =>
  override def userRepository: UserRepository = new UserRepository
  override def bikeRepository: BikeRepository = new BikeRepository
  override def manageUser: ManageUser = new ManageUser(userRepository)
  override def manageBike: ManageBike = new ManageBike(userRepository, bikeRepository)

}
