package com.jp.app.components

import android.content.Context
import android.util.AttributeSet
import com.jp.app.R
import kotlinx.android.synthetic.main.user_component.view.*
import org.joda.time.DateTime

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

    fun setBirth (b: String) {
        birth_user.text = b
    }
}