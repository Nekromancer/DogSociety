package pl.ownvision.dogsociety

import dagger.Module
import dagger.Provides
import pl.ownvision.dogsociety.authorization.Authorization
import pl.ownvision.dogsociety.authorization.ParseAuthorization
import javax.inject.Singleton

@Module
open class AndroidModule() {

    @Provides
    @Singleton
    open fun provideAuthorization(): Authorization {
        return ParseAuthorization()
    }

}