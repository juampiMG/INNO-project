package com.jp.app.model.mapper

import com.jp.app.model.UserView
import com.jp.data.entity.mapper.BaseModelDataMapper
import com.jp.domain.model.UserDomain
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserViewMapper
@Inject
constructor() : BaseModelDataMapper<UserDomain, UserView>() {
    override fun transform(source: UserDomain): UserView {
        val userView = UserView()
        userView.id = source.id
        userView.name = source.name
        userView.birthdate = source.birthdate
        return userView
    }


    override fun inverseTransform(source: UserView): UserDomain {
        val userDomain = UserDomain()
        userDomain.id = source.id
        userDomain.name = source.name
        userDomain.birthdate = source.birthdate
        return userDomain
    }
}