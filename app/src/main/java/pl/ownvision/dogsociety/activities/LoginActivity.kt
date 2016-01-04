package pl.ownvision.dogsociety.activities

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pawegio.kandroid.d
import com.pawegio.kandroid.longToast
import com.pawegio.kandroid.runDelayedOnUiThread
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.content_login.*
import pl.ownvision.dogsociety.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(toolbar)

        link_signup.setOnClickListener {
            // TODO : Intent do rejestracji
            throw NotImplementedError();
        }

        btn_login.setOnClickListener {
            login()
        }
    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }

    fun login() {
        d("Login start")

        btn_login.isEnabled = false

        if (!validate()) {
            onLoginFailed()
            return
        }

        val progressDialog = ProgressDialog(this, R.style.Theme_AppCompat_Dialog_Alert)
        progressDialog.isIndeterminate = true
        progressDialog.setMessage(getString(R.string.authorizing_progress))
        progressDialog.show()

        // TODO : Logika logowania

        runDelayedOnUiThread(5000) {
            progressDialog.dismiss()
            onLoginSuccess()
        }
    }

    fun validate(): Boolean {
        var valid = true

        val email = input_email.text.toString()
        val password = input_password.text.toString()

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            input_email.error = getString(R.string.enter_valid_email)
            valid = false
        } else {
            input_email.error = null
        }

        if (password.isEmpty() || password.length < 4 || password.length > 15) {
            input_password.error = getString(R.string.enter_valid_password)
            valid = false;
        } else {
            input_password.error = null
        }

        return valid
    }

    fun onLoginFailed() {
        btn_login.isEnabled = true
        longToast(getString(R.string.failed_login))
    }

    fun onLoginSuccess() {
        btn_login.isEnabled = true
    }

}
