package com.jp.data.repository

import com.jp.data.entity.mapper.UserMapper
import com.jp.data.network.gateway.IAppGateway
import com.jp.domain.model.UserDomain
import com.jp.domain.repository.IUsersRepository
import io.reactivex.Single
import javax.inject.Inject

class UsersRepository
@Inject
constructor(private val mGateway: IAppGateway) : IUsersRepository {
    @Inject
    internal lateinit var mUserMapper: UserMapper

    override fun getUsers(): Single<List<UserDomain>> {
        return mGateway.getUsers().flatMap { resultEntities ->
            Single.just(mUserMapper.transform(resultEntities))
        }
    }
}