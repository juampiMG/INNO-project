package com.jp.app.common.reactivex

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class CompositeDisposableManager
@Inject
constructor() {

    var mCompositeDisposable: CompositeDisposable? = null


    fun destroyDisposable() {
        mCompositeDisposable?.dispose()
    }

    // =============== Manage Disposable ===========================================================

    fun getCompositeDisposable(): CompositeDisposable {
        val isDisposed = mCompositeDisposable?.isDisposed?.let { it } ?: run { false }
        if (mCompositeDisposable == null || isDisposed)
            mCompositeDisposable = CompositeDisposable()
        return mCompositeDisposable as CompositeDisposable
    }

    fun addDisposable(disposable: Disposable?) {
        if (disposable != null) {
            mCompositeDisposable?.add(disposable)
        }
    }

    fun removeDisposable(disposable: Disposable?) {
        if (disposable != null) {
            if (!disposable.isDisposed) {
                disposable.dispose()
            }
            if (mCompositeDisposable != null) {
                mCompositeDisposable?.remove(disposable)
            }
        }
    }

    fun removeAllDisposables() {
        mCompositeDisposable?.clear()
    }

    fun hasDisposables(): Boolean {
        return if (mCompositeDisposable != null) {
            mCompositeDisposable?.size()?.let { it > 0 } ?: run { false }
        } else {
            false
        }
    }

}
