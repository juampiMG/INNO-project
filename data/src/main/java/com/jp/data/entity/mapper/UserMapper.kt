package com.jp.data.entity.mapper

import com.jp.data.entity.sample.User
import com.jp.domain.model.UserDomain
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserMapper
@Inject
constructor(): BaseModelDataMapper<User, UserDomain>() {

    override fun transform(source: User): UserDomain {
        val userDomain = UserDomain()
        userDomain.id = source.id
        userDomain.name = source.name
        userDomain.birthdate = source.birthdate
        return userDomain
    }

    override fun inverseTransform(source: UserDomain): User {
        val user = User()
        user.id = source.id
        user.name = source.name
        user.birthdate = source.birthdate

        return user
    }

}