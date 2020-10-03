package com.corona.myapplication.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.corona.myapplication.R
import com.corona.myapplication.ui.base.BaseFragment
import com.corona.myapplication.ui.home.HomeViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.frg_detail.*
import javax.inject.Inject

class DetailFrg: BaseFragment<HomeViewModel>() {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    override fun getViewModel(): HomeViewModel = homeViewModel

    lateinit var detailAdapter: DetailAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    var view = inflater.inflate(R.layout.frg_detail, container,false)
    return view
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUp()
        bindViewModel()
    }

    private fun bindViewModel() {
        homeViewModel.countryCoronaData.observe(this, Observer {
            Log.e("==detail==","==${Gson().toJson(it)}")
            detailAdapter.addData(it.province, it.date)

        })
    }

    private fun setUp(){
        homeViewModel.getCasesBasedOnCountry(arguments?.get("countryname").toString())
        setProvinceRecyclerView()
    }

    private fun setProvinceRecyclerView(){
        detailAdapter = DetailAdapter()
        rv_province.adapter = detailAdapter

    }
}