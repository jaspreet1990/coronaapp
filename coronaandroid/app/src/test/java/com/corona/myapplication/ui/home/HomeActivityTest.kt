package com.corona.myapplication.ui.home

 import android.os.Build
 import android.view.LayoutInflater
 import com.corona.myapplication.R
 import org.junit.Before
 import org.junit.Test
 import org.junit.runner.RunWith
 import org.robolectric.Robolectric
 import org.robolectric.RobolectricTestRunner
 import org.robolectric.android.controller.ActivityController
 import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class HomeActivityTest {

    private lateinit var activity: HomeActivity
    lateinit var activityController: ActivityController<HomeActivity>
    @Before
    fun setUpContentView() {

        activityController = Robolectric.buildActivity(HomeActivity::class.java)
        activity = activityController.get()

        val view = LayoutInflater.from(activity).inflate(R.layout.activity_home, null)
        activity.setContentView(view)
    }

    @Test
    fun activityCreatesProperly() {
        activity.finish()
    }

    @Test
    fun setUp() {
        activityController.create().start().postCreate(null).resume()

        val homeFrg = HomeFrg()
        activity.supportFragmentManager.beginTransaction().
        add(R.id.fl_container, homeFrg).commit()
    }
}