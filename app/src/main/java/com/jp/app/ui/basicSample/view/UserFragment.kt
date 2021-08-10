package com.jp.app.ui.basicSample.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.jp.app.R
import com.jp.app.common.view.BaseFragment
import com.jp.app.common.view.IBaseFragmentCallback
import com.jp.app.ui.basicSample.adapter.UserResponseAdapter
import com.jp.app.ui.basicSample.viewModel.UserFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.sample_fragment.*

/**
 * Basic Fragment
 */
@AndroidEntryPoint
class UserFragment : BaseFragment<UserFragmentViewModel, UserFragment.FragmentCallback>() {

    lateinit var mAdapter: UserResponseAdapter

    override fun getLayoutId(): Int {
        return R.layout.sample_fragment
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

    override fun onViewLoaded(savedInstanceState: Bundle?, view: View?) {
        super.onViewLoaded(savedInstanceState, view)
        setUpRecyclerView ()
    }

    private fun setUpRecyclerView() {
       val mLinearLayoutManager = LinearLayoutManager(activity)
        response_server.layoutManager = mLinearLayoutManager
        mAdapter = UserResponseAdapter(mutableListOf())
        response_server.adapter = mAdapter
    }

    override fun subscribeToLiveData() {
        mViewModel.getUsers().observe(viewLifecycleOwner, {
            mAdapter.setUpResponse(it)
        })
    }

    companion object {
        fun newInstance(bundle: Bundle?) = UserFragment().apply {
            arguments = bundle ?: Bundle()
        }
    }

    override fun setUpViews() {

    }

    override fun applyRTLChanges() {
    }


}
