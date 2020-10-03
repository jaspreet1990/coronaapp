package com.corona.myapplication.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.corona.myapplication.R
import com.corona.myapplication.ui.base.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class HomeActivity : BaseActivity() , HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override  fun supportFragmentInjector(): AndroidInjector<Fragment>?  = fragmentDispatchingAndroidInjector


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setUp()
    }

    fun setUp(){
        addOrReplaceFrg(R.id.fl_container,
            HomeFrg(),true,false)
    }
}