package com.corona.myapplication.ui.base

import androidx.lifecycle.ViewModel
import com.corona.myapplication.util.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {

    private val internalErrorLiveData: SingleLiveEvent<Pair<Int, String?>> = SingleLiveEvent()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getInternalErrorObservable() = internalErrorLiveData




    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun postError(messageResId: Int, extraText: String? = null) {
        internalErrorLiveData.postValue(Pair(messageResId, extraText))
    }

}