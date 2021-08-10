package com.jp.data.network.gateway

import com.jp.data.entity.User
import io.reactivex.Single


interface IAppGateway {
    fun getUsers(): Single<List<User>>
}