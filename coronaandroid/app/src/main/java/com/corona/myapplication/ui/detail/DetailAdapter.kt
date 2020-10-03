package com.corona.myapplication.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.corona.myapplication.R
import com.corona.myapplication.repo.model.Province

class DetailAdapter : RecyclerView.Adapter<DetailAdapter.MyViewHolder>() {

    var date: String? = null
    var myDataset: MutableList<Province> = mutableListOf()
    fun addData(
        myData: List<Province>,
        date: String?
    ) {
        myDataset.addAll(myData)
        this.date = date
        notifyDataSetChanged()
    }

    class MyViewHolder( view: View) : RecyclerView.ViewHolder(view){

        var countryName =  view.findViewById(R.id.tv_province) as TextView
        var date = view.findViewById(R.id.tv_date) as TextView
        var active =  view.findViewById(R.id.tv_active) as TextView
        var confirmed =  view.findViewById(R.id.tv_confirmed) as TextView
        var recover =  view.findViewById(R.id.tv_recover) as TextView
        var death =  view.findViewById(R.id.tv_death) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_detail, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.countryName.text = myDataset[position].province
        holder.active.text = myDataset[position].active.toString()
        holder.confirmed.text = myDataset[position].confirmed.toString()
        holder.recover.text = myDataset[position].recovered.toString()
        holder.death.text = myDataset[position].deaths.toString()
        holder.date.text = date
    }

    override fun getItemCount() = myDataset.size
}