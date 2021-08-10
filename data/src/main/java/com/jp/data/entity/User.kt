package com.jp.data.entity

import org.joda.time.DateTime

class User {
    var id: Int = 0 // database entity
    var name: String = ""
    var birthdate: DateTime = DateTime.now()
}