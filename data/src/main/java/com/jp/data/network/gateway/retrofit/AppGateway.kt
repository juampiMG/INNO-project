package com.jp.data.network.gateway.retrofit

import com.jp.data.entity.sample.User
import com.jp.data.network.gateway.IAppGateway
import com.jp.data.preferences.URLPreferenceManager
import com.jp.data.network.gateway.retrofit.service.IRestServices
import io.reactivex.Single

class AppGateway(private val mService: IRestServices, private val urlPreferenceManager: URLPreferenceManager) : IAppGateway {

    override fun getUsers(): Single<List<User>> {
        return mService.getUsers(urlPreferenceManager.getURL() + "user")
    }
}