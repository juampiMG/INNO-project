package com.jp.app.ui

import androidx.test.espresso.IdlingRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.jp.app.helper.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
open class BaseEspressoTest{

    @Before
    open fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }


    @After
    open fun tearDown() {
        EspressoIdlingResource.flush()
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
    }


}