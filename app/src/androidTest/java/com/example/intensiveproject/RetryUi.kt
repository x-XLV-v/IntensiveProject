package com.example.intensiveproject

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.google.android.material.button.MaterialButton
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.not

class
RetryUi(rootId: Int, parent: Matcher<View>) {

    private val id: Int = R.id.retryButton

    private val interaction = onView(
        allOf(
            withId(id),
            isAssignableFrom(MaterialButton::class.java),
            withParent(withId(rootId)),
            parent
        ))

    fun checkNotVisible() {
        interaction.check(matches(not(isDisplayed())))
    }

    fun checkVisible() {
        interaction.check(matches(isDisplayed()))
    }

    fun click() {
        interaction.perform(ViewActions.click())
    }
}
