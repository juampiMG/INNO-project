package com.jp.app.injector.ui

import androidx.lifecycle.ViewModelProvider
import com.jp.app.common.viewModel.ViewModelProviderFactory
import com.jp.app.ui.basicSample.view.UserFragment
import com.jp.app.ui.basicSample.viewModel.IUserFragmentViewModel
import com.jp.app.ui.basicSample.viewModel.UserFragmentViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

/**
 * Module that provide all the FragmentViewModels to the FragmentViews
 */

@InstallIn(FragmentComponent::class)
@Module
object FragmentViewModelsModule {
    @Provides
    fun provideViewModel(fragment: UserFragment): IUserFragmentViewModel {
        return ViewModelProvider(fragment, ViewModelProviderFactory(UserFragmentViewModel()))
            .get(UserFragmentViewModel::class.java)
    }
}