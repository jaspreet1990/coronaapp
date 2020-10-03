package com.corona.myapplication.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.corona.myapplication.R
import com.corona.myapplication.repo.db.CoronaCoutryWiseTable
import com.corona.myapplication.ui.base.BaseFragment
import com.corona.myapplication.ui.detail.DetailFrg
import com.corona.myapplication.util.EndlessRecyclerViewScrollListener
import com.corona.myapplication.util.RecyclerItemClickListener
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.country_wise_list.*
import javax.inject.Inject


class HomeFrg: BaseFragment<HomeViewModel>() {

    @Inject lateinit var homeViewModel: HomeViewModel

    override fun getViewModel(): HomeViewModel = homeViewModel
    lateinit var coronaCountryWiseAdapter: CoronaCountryWiseAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?  =
            inflater.inflate(R.layout.country_wise_list, container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUp()
        bindViewModel()
    }

    var myData: MutableList<CoronaCoutryWiseTable> = mutableListOf()

    private fun bindViewModel() {
        homeViewModel.countryBasedCoronaResponseLiveData.observe(this, Observer {
            Log.e("==res==","==${Gson().toJson(it)}")
         myData = it
         coronaCountryWiseAdapter.addData(myData)
         coronaCountryWiseAdapter.notifyDataSetChanged()
        })
    }

    private fun setUp(){
        homeViewModel.getAllCountries()
        setCoronaInfoRecyclerView()
    }

    private fun setCoronaInfoRecyclerView(){

        val linearLayoutManager = LinearLayoutManager(getActivity())
        rv_corona_data.setLayoutManager(linearLayoutManager)

        coronaCountryWiseAdapter = CoronaCountryWiseAdapter()
        rv_corona_data.adapter = coronaCountryWiseAdapter


        rv_corona_data.addOnItemTouchListener(
            RecyclerItemClickListener(context, rv_corona_data, object : RecyclerItemClickListener.OnItemClickListener {
                override fun onItemClick(view: View, position: Int) {

                    var bundle = Bundle()
                    bundle.putString("countryname", myData[position].countryName)

                    var frg = DetailFrg()
                    frg.arguments = bundle
                    (activity as HomeActivity)
                        .addOrReplaceFrg( R.id.fl_container,
                            frg,
                            true,
                            true )
                }

                override fun onLongItemClick(view: View, position: Int) {

                }
            })
        )

    }
}