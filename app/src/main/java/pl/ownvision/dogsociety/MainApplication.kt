package pl.ownvision.dogsociety

import android.app.Application
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.digits.sdk.android.Digits;
import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.DigitsException
import com.digits.sdk.android.DigitsSession;

class MainApplication : Application() {

    private val TWITTER_KEY = "Rz1IbmkFeiNu8GIDTjaNHNNMK";
    private val TWITTER_SECRET = "b1xyolMh5spw1zn64ph53MApRQdWQ5bsH4yDsZQBLX2CdbUGAz"

    var authCallback : AuthCallback? = null

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics()) // TODO : tylko na release

        val authConfig = TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, TwitterCore(authConfig), Digits());

        authCallback = object : AuthCallback { // FIXME : zwraca nieprawidłowy obiekt?
            override fun failure(exception: DigitsException?) {
                throw RuntimeException("Nie udało się")
            }

            override fun success(session: DigitsSession, phoneNumber: String){
                throw RuntimeException("Udało się")
            }
        }
    }

    public fun getDigitsAuthCallback(): AuthCallback? {
        return authCallback
    }
}
