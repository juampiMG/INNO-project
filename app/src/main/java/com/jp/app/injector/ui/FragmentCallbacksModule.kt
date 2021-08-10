package com.jp.app.injector.ui

import com.jp.app.ui.basicSample.activity.view.UserActivity
import com.jp.app.ui.basicSample.view.UserFragment
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

/**
 * Module that Binds all the FragmentCallbacks to the Actvities
 */
@InstallIn(FragmentComponent::class)
@Module
abstract class FragmentCallbacksModule {
    /**
     * Bind the Fragment Callback
     */
    @Binds
    internal abstract fun parentFragmentCallback(activity: UserActivity): UserFragment.FragmentCallback
}