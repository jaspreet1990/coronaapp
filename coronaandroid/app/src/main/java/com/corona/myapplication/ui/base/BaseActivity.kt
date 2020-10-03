package com.corona.myapplication.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        if (hasInjector())
            AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

    }


    open fun hasInjector() = true

     fun addOrReplaceFrg(containerID:Int, frg: Fragment, isAdd:Boolean, isAddToBackStack:Boolean){

       var transaction= supportFragmentManager.beginTransaction()
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
}