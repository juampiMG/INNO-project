package com.jp.app.ui.basicSample.viewModel

import androidx.lifecycle.MutableLiveData
import com.jp.app.common.viewModel.BaseFragmentViewModel
import com.jp.app.helper.subscribeSingle
import com.jp.app.model.UserView
import com.jp.app.model.mapper.UserViewMapper
import com.jp.domain.interactor.IGetUsersUseCase
import javax.inject.Inject

class UserFragmentViewModel
@Inject
constructor() : BaseFragmentViewModel(), IUserFragmentViewModel {

    private var mUsers = MutableLiveData<List<UserView>>()

    @Inject
    lateinit var mGetUsersUseCase: IGetUsersUseCase

    @Inject
    lateinit var mUserViewMapper: UserViewMapper

    override fun loadData() {
        addDisposable(
                mGetUsersUseCase.execute().subscribeSingle(
                        onStart = {
                            isLoading(true)
                        },
                        onSuccess = {
                            isLoading(false)
                            mUsers.value = mUserViewMapper.transform(it)
                        },
                        onError = { _, _, _ ->
                            isLoading(false)
                        }
                )
        )
    }

    override fun getUsers(): MutableLiveData<List<UserView>> {
        return mUsers
    }

}
