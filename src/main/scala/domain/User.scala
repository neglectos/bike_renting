package domain

case class User(name: String, var balance: Int, var state: Boolean = false)