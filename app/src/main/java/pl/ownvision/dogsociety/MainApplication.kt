package pl.ownvision.dogsociety

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.parse.Parse
import io.fabric.sdk.android.Fabric;

open class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (!BuildConfig.DEBUG)
            Fabric.with(this, Crashlytics())
        Parse.initialize(this, BuildConfig.PARSE_APPLICATION_ID, BuildConfig.PARSE_CLIENT_KEY);

        // TODO : Log user into crashlytics https://fabric.io/kits/android/crashlytics/features
    }
}
