package pl.ownvision.dogsociety

var created: Boolean = false
var terminated: Boolean = false

class TestMainApplication : MainApplication() {


    override fun onCreate() {
        if (!created) {
            super.onCreate()
            created = true
        }
    }

    override fun onTerminate() {
        if (!terminated) {
            super.onTerminate()
            terminated = true
        }
    }
}