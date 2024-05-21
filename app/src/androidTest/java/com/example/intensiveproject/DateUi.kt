package com.example.intensiveproject

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

class DateUi(rootId: Int, parent: Matcher<View>) {

    private val id: Int = R.id.dateTextView

    private val interaction = onView(
        allOf(
            withId(id),
            isAssignableFrom(TextView::class.java),
            withParent(withId(rootId)),
            parent
        ))

    fun checkCryptoInfoState() {
        interaction.check(matches(isDisplayed()))
    }
}
