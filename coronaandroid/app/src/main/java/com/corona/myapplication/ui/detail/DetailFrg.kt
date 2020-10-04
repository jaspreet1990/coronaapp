package com.corona.myapplication.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.corona.myapplication.R
import com.corona.myapplication.ui.base.BaseFragment
import com.corona.myapplication.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.frg_detail.*
import kotlinx.android.synthetic.main.frg_detail.view.*
import javax.inject.Inject

open class DetailFrg: BaseFragment<HomeViewModel>() {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    override fun getViewModel(): HomeViewModel = homeViewModel

    lateinit var detailAdapter: DetailAdapter
    lateinit var rvProvince: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    var view = inflater.inflate(R.layout.frg_detail, container,false)
    rvProvince = view.findViewById<RecyclerView>(R.id.rv_province)
    return view
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUp()
        getCases()
        bindViewModel()
    }

    private fun bindViewModel() {
        homeViewModel.countryCoronaData.observe(this, Observer {
            detailAdapter.addData(it.province, it.date)
        })
    }

     fun setUp(){
        setProvinceRecyclerView()
     }

    fun getCases() {
        homeViewModel.getCasesBasedOnCountry(arguments?.get("countryname").toString())
    }

    private fun setProvinceRecyclerView(){
        detailAdapter = DetailAdapter()
        rvProvince.adapter = detailAdapter
    }
}