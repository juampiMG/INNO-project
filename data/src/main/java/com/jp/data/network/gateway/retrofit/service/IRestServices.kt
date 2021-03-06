package com.jp.data.network.gateway.retrofit.service

import com.jp.data.entity.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Services without authentication at the header
 */
interface IRestServices {
    @GET
    fun getUsers(@Url url: String): Single<List<User>>
}