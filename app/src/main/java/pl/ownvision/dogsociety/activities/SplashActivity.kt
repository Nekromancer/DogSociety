package pl.ownvision.dogsociety.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.parse.ParseUser
import com.pawegio.kandroid.startActivity
import pl.ownvision.dogsociety.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            //val intent = Intent(MainActivity.this, Welcome.class);
            //startActivity(intent);
            finish();
        } else {
            startActivity<LoginActivity>()
            finish();
        }
    }
}
