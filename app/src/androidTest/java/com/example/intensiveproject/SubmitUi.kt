package com.example.intensiveproject

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.google.android.material.button.MaterialButton
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

class SubmitUi(rootId: Int, parent: Matcher<View>) {

    private val id: Int = R.id.submitButton

    private val interaction = onView(
        allOf(
            withId(id),
            isAssignableFrom(MaterialButton::class.java),
            withParent(withId(rootId)),
            parent
        ))

    fun click() {
        interaction.perform(androidx.test.espresso.action.ViewActions.click())
    }
}
