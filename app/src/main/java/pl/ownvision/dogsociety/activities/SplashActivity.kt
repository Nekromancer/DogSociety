package pl.ownvision.dogsociety.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pawegio.kandroid.startActivity
import pl.ownvision.dogsociety.MainApplication
import pl.ownvision.dogsociety.R
import pl.ownvision.dogsociety.authorization.Authorization
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var auth: Authorization

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        MainApplication.graph.inject(this)

        if (auth.isLoggedIn()) {
            startActivity<MainActivity>()
            finish();
        } else {
            startActivity<LoginActivity>()
            finish();
        }
    }
}
