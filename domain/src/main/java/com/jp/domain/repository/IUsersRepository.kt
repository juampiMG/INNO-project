package com.jp.domain.repository

import com.jp.domain.model.UserDomain
import io.reactivex.Single

interface IUsersRepository {
     fun getUsers(): Single<List<UserDomain>>
}