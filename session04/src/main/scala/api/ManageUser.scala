package api
import com.google.inject.Inject
import domain.{User, UserTrait}

trait ManageUserTrait  {
  def createUser(name: String, balance: Int): User
  def loginUser(user: User): User
  def logoffUser(user: User): User
  def reduceBalance(user: User, amount: Int)
  def addBalance(user: User, amount: Int)
}

case class ManageUser @Inject()(userRepository: UserTrait) extends ManageUserTrait {

    def createUser(name: String, balance: Int): User = loginUser(userRepository.createUser(name, balance))

    def loginUser(user: User): User = userRepository.loginUser(user)

    def logoffUser(user: User): User = userRepository.logoffUser(user)

    def reduceBalance(user: User, amount: Int): Unit = {
      user.balance = user.balance - amount
      println(s"${user.name}'s balance is ${user.balance} - FROM API")
    }

    def addBalance(user: User, amount: Int): Unit = {
      user.balance = user.balance + amount
      println(s"${user.name}'s balance is ${user.balance} - FROM API")
    }

}
