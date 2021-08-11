package com.jp.app.ui.basicSample.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jp.app.R
import com.jp.app.common.view.BaseFragment
import com.jp.app.common.view.IBaseFragmentCallback
import com.jp.app.ui.basicSample.adapter.UserResponseAdapter
import com.jp.app.ui.basicSample.viewModel.UserFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.user_fragment.*

/**
 * Basic Fragment
 */
@AndroidEntryPoint
class UserFragment : BaseFragment<UserFragmentViewModel, UserFragment.FragmentCallback>() {

    lateinit var mAdapter: UserResponseAdapter

    override fun getLayoutId(): Int {
        return R.layout.user_fragment
    }

    interface FragmentCallback : IBaseFragmentCallback


    override fun getFragmentTitle(): String {
        return "UserFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mViewModel.loadData()
        }
    }

    override fun subscribeToLiveData() {
        mViewModel.getUsers().observe(viewLifecycleOwner, {
            if (it.isNotEmpty()) {
                runLayoutAnimation()
                mAdapter.setUpResponse(it)
            }

        })
    }

    companion object {
        fun newInstance(bundle: Bundle?) = UserFragment().apply {
            arguments = bundle ?: Bundle()
        }
    }

    override fun setUpViews() {
        setUpRecyclerView ()
    }

    override fun applyRTLChanges() {
    }

    private fun setUpRecyclerView() {
        val mLinearLayoutManager = LinearLayoutManager(activity)
        response_server.layoutManager = mLinearLayoutManager
        mAdapter = UserResponseAdapter(mutableListOf())
        response_server.adapter = mAdapter
    }

    private fun runLayoutAnimation() {
        val context: Context = response_server.context
        val controller: LayoutAnimationController = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down)
        response_server.layoutAnimation = controller
        response_server.scheduleLayoutAnimation()
    }


}
