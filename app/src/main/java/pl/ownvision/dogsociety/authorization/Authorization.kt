package pl.ownvision.dogsociety.authorization

interface Authorization {

    fun logIn(email: String, password: String, callback: () -> Unit)
    fun register(email: String, password: String, callback: () -> Unit)
    fun isLoggedIn(): Boolean
    fun currentUserEmail(): String
}