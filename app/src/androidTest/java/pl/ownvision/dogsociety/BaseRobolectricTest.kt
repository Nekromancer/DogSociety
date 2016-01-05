package pl.ownvision.dogsociety

import org.junit.runner.RunWith
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricGradleTestRunner::class)
@Config(constants = BuildConfig::class, sdk = intArrayOf(21), application = TestMainApplication::class)
public abstract class BaseRobolectricTest {}