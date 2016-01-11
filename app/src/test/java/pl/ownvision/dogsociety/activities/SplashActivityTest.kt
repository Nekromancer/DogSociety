package pl.ownvision.dogsociety.activities

import com.pawegio.kandroid.IntentFor
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.robolectric.Robolectric
import pl.ownvision.dogsociety.*
import pl.ownvision.dogsociety.authorization.Authorization
import org.mockito.MockitoAnnotations
import org.robolectric.Shadows.*
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*

class SplashActivityTest : BaseRobolectricTest() {

    lateinit var activity: SplashActivity

    @Mock
    lateinit var authProvider: Authorization

    @Mock
    lateinit var module: AndroidModule

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this);

        `when`(module.provideAuthorization()).thenReturn(authProvider)

        MainApplication.graph = DaggerApplicationComponent.builder().androidModule(module).build()
    }

    @Test
    fun userNotLoggedIn() {
        `when`(authProvider.isLoggedIn()).thenReturn(false)
        activity = Robolectric.setupActivity(SplashActivity::class.java)

        val expectedIntent = IntentFor<LoginActivity>(activity)
        assertThat(shadowOf(activity).getNextStartedActivity(), equalTo(expectedIntent))
    }

    @Test
    fun userLoggedIn() {
        `when`(authProvider.isLoggedIn()).thenReturn(true)
        activity = Robolectric.setupActivity(SplashActivity::class.java)

        val expectedIntent = IntentFor<MainActivity>(activity)
        assertThat(shadowOf(activity).getNextStartedActivity(), equalTo(expectedIntent))
    }
}