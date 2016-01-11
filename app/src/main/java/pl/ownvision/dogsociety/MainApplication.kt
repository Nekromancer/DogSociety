package pl.ownvision.dogsociety

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.parse.Parse
import io.fabric.sdk.android.Fabric;

open class MainApplication : Application() {

    companion object {
        @JvmStatic lateinit public var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        graph = DaggerApplicationComponent.builder().androidModule(AndroidModule()).build()
        graph.inject(this)

        if (!BuildConfig.DEBUG)
            Fabric.with(this, Crashlytics())
        Parse.initialize(this, BuildConfig.PARSE_APPLICATION_ID, BuildConfig.PARSE_CLIENT_KEY);
    }
}
