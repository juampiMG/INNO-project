package com.jp.app.components

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import com.jp.app.R
import kotlinx.android.synthetic.main.user_component.view.*
import org.joda.time.DateTime
import org.joda.time.LocalDateTime

class UserComponent : BaseComponentView {
    override val layoutId: Int
        get() = R.layout.user_component

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun loadAttributes(context: Context, attrs: AttributeSet?) {

    }

    override fun loadData() {

    }

    fun setName (n: String) {
        name_user.text = n
    }

    @SuppressLint("SetTextI18n")
    fun setBirth (d: LocalDateTime) {
        val day = if (d.dayOfMonth().get() >9) d.dayOfMonth().get() else "0${d.dayOfMonth().get()}"
        val month = if (d.monthOfYear().get() >9) d.monthOfYear().get() else "0${d.monthOfYear().get()}"
        birth_user.text = "$day-$month-${d.year().get()}"
    }
}