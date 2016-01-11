package pl.ownvision.dogsociety

import dagger.Component
import pl.ownvision.dogsociety.activities.SplashActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidModule::class))
interface ApplicationComponent {
    fun inject(application: MainApplication)

    fun inject(splashActivity: SplashActivity)
}