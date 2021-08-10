package com.jp.domain.interactor.impl

import com.jp.domain.interactor.IGetUsersUseCase
import com.jp.domain.model.UserDomain
import com.jp.domain.repository.IUsersRepository
import io.reactivex.Single
import javax.inject.Inject

class GetUsersUseCase
@Inject
constructor() : IGetUsersUseCase {

    @Inject
    internal lateinit var mUsersRepository: IUsersRepository

    override fun execute(): Single<List<UserDomain>> {
        return mUsersRepository.getUsers()
    }
}