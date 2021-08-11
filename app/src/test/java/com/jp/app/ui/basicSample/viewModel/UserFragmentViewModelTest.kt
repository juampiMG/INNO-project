package com.jp.app.ui.basicSample.viewModel

import com.jp.app.BaseTest
import com.jp.app.common.reactivex.CompositeDisposableManager
import com.jp.app.model.mapper.UserViewMapper
import com.jp.app.utils.DataCreator
import com.jp.domain.interactor.IGetUsersUseCase
import io.reactivex.Single
import org.junit.Assert
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

class UserFragmentViewModelTest: BaseTest() {

    @Mock
    lateinit var mGetUsersUseCase: IGetUsersUseCase

    @InjectMocks
    lateinit var mUserViewMapper: UserViewMapper

    lateinit var viewModel: UserFragmentViewModel

    override fun setup() {
        viewModel = UserFragmentViewModel()
        viewModel.mCompositeDisposableManager = CompositeDisposableManager()
        viewModel.mCompositeDisposableManager.mCompositeDisposable = viewModel.mCompositeDisposableManager.getCompositeDisposable()
    }

    @Test
    fun `check users call`() {
        Mockito.`when`(mGetUsersUseCase.execute()).thenReturn(Single.just( DataCreator.getUsers ()))
        viewModel.mGetUsersUseCase = mGetUsersUseCase
        viewModel.mUserViewMapper = mUserViewMapper
        viewModel.loadData()
        Assert.assertNotNull( viewModel.getUsers().value)
    }
}