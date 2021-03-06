package domain

trait UserTrait {
  def loginUser(user: User): User
  def logoffUser(user: User): User
  def createUser(name: String, balance: Int): User
  def deleteUser(user: User)
}

class UserRepository extends  UserTrait{

  def loginUser(user: User): User = {
    println(s"${user.name} has been logged in successfully - FROM DOMAIN")
    user.state = true
    user
  }

  def logoffUser(user: User): User = {
    println(s"${user.name} has been logged off successfully - FROM DOMAIN")
    user.state = false
    user
  }

  def createUser(name: String, balance: Int): User = {
    println("User has been created successfully - FROM DOMAIN")
    new User(name, balance)
  }

  def deleteUser(user: User): Unit = {
    println(s"$user is deleted successfully - FROM DOMAIN")
  }


}