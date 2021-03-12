package com.playground.atid.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import com.applitools.eyes.android.common.logger.StdoutLogHandler
import com.applitools.eyes.android.components.androidx.AndroidXComponentsProvider
import com.applitools.eyes.android.espresso.Eyes
import com.playground.atid.MainActivity
import org.junit.Rule
import org.junit.Test
import java.net.URI

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleApplitoolsTest {

    /**
     * Rule defining which activity should be launched at the start of each test.
     */
    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    private val eyes: Eyes = Eyes(URI("https://localhost"))

    init {
        with(eyes) {
            apiKey = "put_your_api_key_here"
            logHandler = StdoutLogHandler(true)
            appName = InstrumentationRegistry.getInstrumentation().targetContext.getString(R.string.app_name)
            componentsProvider = AndroidXComponentsProvider()
        }
    }

    @Test
    fun doTest() {
        try {
            eyes.open("test")
            eyes.checkWindow("Screenshot")
            eyes.close()
        } finally {
            eyes.abortIfNotClosed()
        }
    }
}