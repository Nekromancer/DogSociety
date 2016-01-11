package pl.ownvision.dogsociety.authorization

class ParseAuthorization: Authorization {
    override fun logIn(email: String, password: String, callback: () -> Unit) {
        // TODO : Log user into crashlytics https://fabric.io/kits/android/crashlytics/features
        throw UnsupportedOperationException()
    }

    override fun register(email: String, password: String, callback: () -> Unit) {
        throw UnsupportedOperationException()
    }

    override fun isLoggedIn(): Boolean {
        return true
    }

    override fun currentUserEmail(): String {
        throw UnsupportedOperationException()
    }

}