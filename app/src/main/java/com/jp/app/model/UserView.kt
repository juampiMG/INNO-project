package com.jp.app.model

import org.joda.time.LocalDateTime

class UserView {
    var id: Int = 0 // database entity
    var name: String = ""
    var birthdate = LocalDateTime.now()
}
