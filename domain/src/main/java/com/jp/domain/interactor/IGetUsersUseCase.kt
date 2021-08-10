package com.jp.domain.interactor

import com.jp.domain.model.UserDomain
import io.reactivex.Single

interface IGetUsersUseCase {

    fun execute(): Single<List<UserDomain>>
}