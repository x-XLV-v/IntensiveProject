package com.example.intensiveproject

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

class DataUi(rootId: Int, parent: Matcher<View>?) {

    private val interaction = onView(
        allOf(
            withId(R.id.dateTextView),
            isAssignableFrom(TextView::class.java),
            withParent(withId(rootId)),
            parent
        ))

    fun check(data: String) {
        interaction.check(matches(withText(data)))
    }
}
