package pl.ownvision.dogsociety

import android.app.Application
import android.widget.Toast
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
        if (!BuildConfig.DEBUG)
            Fabric.with(this, Crashlytics())

        val authConfig = TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET)
        val digits = Digits()

        Fabric.with(this, TwitterCore(authConfig), digits)

        authCallback = object : AuthCallback {
            override fun failure(exception: DigitsException?) {
                Crashlytics.logException(exception)
                // TODO : dialog niepowodzenia
            }

            override fun success(session: DigitsSession, phoneNumber: String?){
                val phone = phoneNumber ?: session.phoneNumber
                Toast.makeText(getApplicationContext(),
                        "Poprawnie zalogowano numerem: ${phone}",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public fun getDigitsAuthCallback(): AuthCallback? {
        return authCallback
    }
}
