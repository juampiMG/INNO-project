package com.jp.app.ui.basicSample

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.jp.app.R
import com.jp.app.ui.BaseEspressoTest
import com.jp.app.ui.basicSample.activity.view.UserActivity
import org.junit.Test
import org.hamcrest.Matchers
import org.junit.Rule

class UserFragmentTest : BaseEspressoTest() {

    @Rule
    @JvmField
    var mUserActivity = ActivityTestRule(UserActivity::class.java)

    @Test
    fun check_user_list_label(){
        val userListLabel = Espresso.onView(
            Matchers.allOf(
                withText(R.string.user_list_title),
                ViewMatchers.isDisplayed()
            )
        )
        userListLabel.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


    @Test
    fun check_user_on_list(){
        val user = Espresso.onView(
            Matchers.allOf(
                withId(R.id.response_server),
                ViewMatchers.isDisplayed()
            )
        )
        user.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}