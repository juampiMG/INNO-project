package com.jp.app.ui.basicSample.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jp.app.components.UserComponent
import com.jp.app.model.UserView

class UserResponseAdapter constructor(
    private var list: MutableList<UserView>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val gymBannerView = UserComponent(parent.context).apply {
            layoutParams = androidx.recyclerview.widget.RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }
        return UserViewHolder(gymBannerView)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setUpResponse (l : List<UserView>) {
        list = l as MutableList<UserView>
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        drawUser(holder as UserViewHolder, list[position])
    }

    private fun drawUser(holder: UserViewHolder, user: UserView) {
        holder.bindView(user)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class UserViewHolder(private val mItemView: UserComponent) : androidx.recyclerview.widget.RecyclerView.ViewHolder(mItemView){
        fun bindView(user: UserView) {
            mItemView.setName(user.name)
            mItemView.setBirth(user.birthdate)
        }
    }

}