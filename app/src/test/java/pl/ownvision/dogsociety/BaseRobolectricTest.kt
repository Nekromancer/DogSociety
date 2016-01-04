package pl.ownvision.dogsociety.activities

import org.junit.runner.RunWith
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config
import pl.ownvision.dogsociety.BuildConfig
import pl.ownvision.dogsociety.TestMainApplication

@RunWith(RobolectricGradleTestRunner::class)
@Config(constants = BuildConfig::class, sdk = intArrayOf(21), application = TestMainApplication::class)
public abstract class BaseRobolectricTest {}