package com.jp.app.ui.basicSample.view

import android.os.Bundle
import com.jp.app.R
import com.jp.app.common.view.BaseFragment
import com.jp.app.common.view.IBaseFragmentCallback
import com.jp.app.ui.basicSample.viewModel.UserFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Basic Fragment
 */
@AndroidEntryPoint
class UserFragment : BaseFragment<UserFragmentViewModel, UserFragment.FragmentCallback>() {
    override fun getLayoutId(): Int {
        return R.layout.sample_fragment
    }

    interface FragmentCallback : IBaseFragmentCallback {

    }


    override fun getFragmentTitle(): String {
        return "SampleFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mViewModel.loadData()
        }
    }

    override fun subscribeToLiveData() {
        mViewModel.getUsers().observe(viewLifecycleOwner, {
           var a = true
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
