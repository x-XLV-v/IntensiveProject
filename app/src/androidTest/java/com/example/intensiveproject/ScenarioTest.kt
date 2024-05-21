package com.example.intensiveproject

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class ScenarioTest {

    @get:Rule
    val scenarioRule = ActivityScenarioRule(MainActivity::class.java)

    private lateinit var cryptoPage: CryptoPage
    private lateinit var loadPage: LoadPage

    @Before
    fun setup() {
        cryptoPage = CryptoPage(data = "1")
        loadPage = LoadPage()
    }

    /**
     *     TestCase N1
     * 1.Run
     *      State progress
     * 2.Wait error
     *      State error
     * 3.Click Retry button
     *      State progress
     * 4.Wait error
     *      State crypto info
     * 5.Сlick Load new
     *      State progress
     * 6.Wait error
     *      State error
     * 7.Click Retry button
     *      State progress
    */

    @Test
    fun caseNumber1() {

        loadPage.checkProgressState()

        scenarioRule.scenario.recreate()
        loadPage.checkProgressState()

        loadPage.waitUntilError()
        loadPage.checkErrorState(message = "No internet connection")

        scenarioRule.scenario.recreate()
        loadPage.checkErrorState(message = "No internet connection")

        loadPage.clickRetry()
        loadPage.checkProgressState()

        scenarioRule.scenario.recreate()
        loadPage.checkProgressState()

        loadPage.waitUntilDisappear()
        cryptoPage.checkCryptoInfoState()

        scenarioRule.scenario.recreate()
        cryptoPage.checkCryptoInfoState()

        cryptoPage.clickNewLoad()
        loadPage.checkProgressState()


        scenarioRule.scenario.recreate()
        loadPage.checkProgressState()

        loadPage.waitUntilError()
        loadPage.checkErrorState(message = "No internet connection")

        scenarioRule.scenario.recreate()
        loadPage.checkErrorState(message = "No internet connection")

        loadPage.clickRetry()
        loadPage.checkProgressState()

        scenarioRule.scenario.recreate()
        loadPage.checkProgressState()

        loadPage.waitUntilDisappear()

        cryptoPage = CryptoPage(data = "2")
        cryptoPage.checkCryptoInfoState()
    }
}