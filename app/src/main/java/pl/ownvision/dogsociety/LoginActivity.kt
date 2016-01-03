package pl.ownvision.dogsociety

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.content_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(toolbar)

        val callback = (application as MainApplication).getDigitsAuthCallback()
        auth_button.setCallback(callback)

        fab.setOnClickListener {
            throw RuntimeException("test")
        }
    }

}
