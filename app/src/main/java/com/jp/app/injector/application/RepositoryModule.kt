package com.jp.app.injector.application

import com.jp.data.repository.UsersRepository
import com.jp.domain.repository.IUsersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    internal abstract fun sampleRepository(repository: UsersRepository): IUsersRepository
}
