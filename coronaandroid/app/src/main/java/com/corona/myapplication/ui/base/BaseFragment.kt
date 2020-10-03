package com.corona.myapplication.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

import androidx.lifecycle.Observer
import com.corona.myapplication.util.longToast
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment<out VM : BaseViewModel> : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (hasInjector()) {
            AndroidSupportInjection.inject(this)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewModel().getInternalErrorObservable().observe(viewLifecycleOwner, Observer {
            it?.let {
                val message = if (it.second == null) getString(it.first) else getString(it.first, it.second)
                activity?.longToast(message)
            }
        })
    }

    fun addOrReplaceFrg(containerID:Int, frg: Fragment, isAdd:Boolean, isAddToBackStack:Boolean){

        var transaction= childFragmentManager.beginTransaction()
        if (isAdd){
            transaction.add(containerID,frg)
        } else{
            transaction.replace(containerID,frg)
        }

        if (isAddToBackStack){
            transaction.addToBackStack(null)
        }

        transaction.commit()
    }
    open fun hasInjector() = true

    abstract fun getViewModel(): VM
}