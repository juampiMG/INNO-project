package com.jp.app.injector.application

import com.jp.domain.interactor.IGetUsersUseCase
import com.jp.domain.interactor.impl.GetUsersUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class UseCaseModule {
    @Binds
    @Singleton
    internal abstract fun getSampleUseCase(useCase: GetUsersUseCase): IGetUsersUseCase
}
