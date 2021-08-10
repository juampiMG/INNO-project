package com.jp.app.ui.basicSample.viewModel

import androidx.lifecycle.MutableLiveData
import com.jp.app.common.viewModel.IBaseActivityViewModel
import com.jp.app.model.UserView

interface IUserFragmentViewModel : IBaseActivityViewModel {
    fun loadData()
    fun getUsers (): MutableLiveData <List<UserView>>
}
