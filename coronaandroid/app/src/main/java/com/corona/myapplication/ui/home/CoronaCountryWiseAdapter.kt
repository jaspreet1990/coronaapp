package com.corona.myapplication.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.corona.myapplication.R
import com.corona.myapplication.repo.db.CoronaCoutryWiseTable

class CoronaCountryWiseAdapter :
    RecyclerView.Adapter<CoronaCountryWiseAdapter.MyViewHolder>() {

    var myDataset: MutableList<CoronaCoutryWiseTable> = mutableListOf()
    fun addData( myData: MutableList<CoronaCoutryWiseTable>) {
        myDataset.addAll(myData)
    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view){

         var countryName =  view.findViewById(R.id.tv_name) as TextView
    }

     override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
         val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_country_detail, parent, false)

        return MyViewHolder(view)
    }

     override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

         holder.countryName.text = myDataset[position].countryName
    }

     override fun getItemCount() = myDataset.size
}