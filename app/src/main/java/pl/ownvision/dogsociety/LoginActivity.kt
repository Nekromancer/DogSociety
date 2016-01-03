package pl.ownvision.dogsociety

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.digits.sdk.android.DigitsAuthButton;

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val digitsButton = findViewById(R.id.auth_button) as DigitsAuthButton
        val callback = (application as MainApplication).getDigitsAuthCallback()
        digitsButton.setCallback(callback)


        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener {
            throw RuntimeException("test")
        }
    }

}
