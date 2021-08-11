package com.jp.app.helper

import androidx.test.espresso.idling.CountingIdlingResource

/**
 * This is class is useful to get control when a API call or a view is created
 * This is used into a Espresso Test
 * Every time we want to know if an asynchronous event is finished we must put:
 *  * Before called ->  EspressoIdlingResource.increment()
 *  * After ended ->  EspressoIdlingResource.decrement()
 *
 * Is Added into :
 *  - every RxJava Call see [RxHelper]
 *  - every time an Activity is created or a Fragment, see [BaseActivity.kt] and [BaseFragment.kt]
 */
object EspressoIdlingResource {
    private const val RESOURCE = "ControlGlobalIdle"
    @JvmField
    val countingIdlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        countingIdlingResource.increment()
    }

    fun decrement() {
        if (!countingIdlingResource.isIdleNow) {
            countingIdlingResource.decrement()
        }

    }

    fun flush() {
        while (!countingIdlingResource.isIdleNow) {
            countingIdlingResource.decrement()
        }
    }

}