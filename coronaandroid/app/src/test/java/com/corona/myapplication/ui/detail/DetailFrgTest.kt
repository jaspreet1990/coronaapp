package com.corona.myapplication.ui.detail

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import com.corona.myapplication.domain.CoronaInfoService
import com.corona.myapplication.domain.CoronaInfoUseCase
import com.corona.myapplication.domain.MockCoronaInfoUseCase
import com.corona.myapplication.repo.ApiService
import com.corona.myapplication.repo.db.CoronaCoutryWiseTable
import com.corona.myapplication.repo.model.*
import com.corona.myapplication.ui.home.HomeActivity
import com.corona.myapplication.ui.home.HomeViewModel
import com.corona.myapplication.util.SingleLiveEvent
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Observable
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class DetailFrgTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    lateinit var activity: AppCompatActivity
    lateinit var fragmentManager: FragmentManager
    lateinit var testFragment: DetailFrg

    lateinit var coronaInfoService: CoronaInfoService

    @Mock
    lateinit var homeViewModel: HomeViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        activity =  Robolectric.setupActivity(HomeActivity::class.java)
        fragmentManager = activity.supportFragmentManager
        testFragment = DetailFrg()
        coronaInfoService = MockCoronaInfoUseCase()
        homeViewModel = HomeViewModel(coronaInfoUseCase = coronaInfoService)
        testFragment.homeViewModel = homeViewModel
    }

    @Test
    fun testGetCasesBasedCountry() {
        testFragment.getCases()
    }
}