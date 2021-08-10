package com.jp.app.ui.basicSample.activity.view

import android.os.Bundle
import com.jp.app.R
import com.jp.app.common.activity.BaseActivity
import com.jp.app.ui.basicSample.activity.viewModel.IUserActivityViewModel
import com.jp.app.ui.basicSample.view.UserFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Remember to add activity to the AndroidManifest.xml and to the InjectorModule.kt
 */
@AndroidEntryPoint
class UserActivity @Inject constructor(): BaseActivity<IUserActivityViewModel>(),
        UserFragment.FragmentCallback {

    override fun getLayoutId(): Int {
        return R.layout.generic_activity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.let {
            supportFragmentManager.findFragmentById(R.id.content)?.let { fr ->
                mCurrentFragment = fr
                loadFragment(addToBackStack = false)
            }
        }?: run {
            mCurrentFragment = UserFragment.newInstance(mExtras)
            loadFragment(addToBackStack = false)
        }

    }

    override fun subscribeToLiveData() {
    }
}