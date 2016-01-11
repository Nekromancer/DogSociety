package pl.ownvision.dogsociety

class TestMainApplication : MainApplication() {

    companion object {
        @JvmStatic public var created: Boolean = false
        @JvmStatic public var terminated: Boolean = false
    }

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