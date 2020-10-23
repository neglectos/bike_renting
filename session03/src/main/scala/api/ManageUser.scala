package api
import domain.{User, UserRepository}

case class ManageUser(userRepository: UserRepository) {

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

    def deleteUser(user: User): Unit = {
      userRepository.deleteUser(user)
    }
}
