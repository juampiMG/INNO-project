package com.jp.app.utils

import com.jp.app.model.UserView
import com.jp.domain.model.UserDomain
import org.joda.time.LocalDateTime

object DataCreator {
    @JvmStatic
    fun getUser1 (): UserDomain {
        val user = UserDomain()
        user.birthdate = "1982-01-28T13:42:17.546"
        user.name = "Juan"
        user.id = 1
        return user
    }

    @JvmStatic
    fun getUser2 (): UserDomain {
        val user = UserDomain()
        user.birthdate = "1988-03-28T13:42:17.546"
        user.name = "Cristina"
        user.id = 2
        return user
    }


    @JvmStatic
    fun getUser3 (): UserDomain {
        val user = UserDomain()
        user.birthdate = "1976-05-12T13:42:17.546"
        user.name = "Pedro"
        user.id = 3
        return user
    }

    @JvmStatic
    fun getUsers (): List<UserDomain> {
       val list = mutableListOf<UserDomain>()
        list.add(getUser1())
        list.add(getUser2())
        list.add(getUser3())
        return list
    }

}