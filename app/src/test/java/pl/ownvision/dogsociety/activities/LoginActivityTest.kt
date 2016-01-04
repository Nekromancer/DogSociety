package pl.ownvision.dogsociety.activities

import android.widget.Button
import android.widget.EditText
import com.pawegio.kandroid.find
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.notNullValue
import org.hamcrest.Matchers.nullValue
import org.junit.Before
import org.junit.Test
import org.robolectric.Robolectric
import pl.ownvision.dogsociety.R

class LoginActivityTest : BaseRobolectricTest() {

    var loginActivity: LoginActivity? = null
    var emailInput: EditText? = null
    var passwordInput: EditText? = null

    @Before
    fun setup() {
        loginActivity = Robolectric.setupActivity(LoginActivity::class.java)
        emailInput = loginActivity!!.find<EditText>(R.id.input_email)
        passwordInput = loginActivity!!.find<EditText>(R.id.input_password)
    }

    @Test
    fun loginWithoutEmailAndPassword() {
        loginActivity!!.find<Button>(R.id.btn_login).performClick()

        assertThat(emailInput!!.error, notNullValue())
        assertThat(passwordInput!!.error, notNullValue())
    }

    @Test
    fun loginWithoutEmail() {
        passwordInput!!.text.append("test")

        loginActivity!!.find<Button>(R.id.btn_login).performClick()

        assertThat(emailInput!!.error, notNullValue())
        assertThat(passwordInput!!.error, nullValue())
    }

    @Test
    fun loginWithoutPassword() {
        emailInput!!.text.append("test@gmail.com")

        loginActivity!!.find<Button>(R.id.btn_login).performClick()

        assertThat(emailInput!!.error, nullValue())
        assertThat(passwordInput!!.error, notNullValue())
    }

    @Test
    fun loginWithInvalidEmail() {
        emailInput!!.text.append("test")
        loginActivity!!.find<Button>(R.id.btn_login).performClick()

        assertThat(emailInput!!.error, notNullValue())
        emailInput!!.text.append("@gmail")
        loginActivity!!.find<Button>(R.id.btn_login).performClick()

        assertThat(emailInput!!.error, notNullValue())
    }

    // TODO : Invalid password
}