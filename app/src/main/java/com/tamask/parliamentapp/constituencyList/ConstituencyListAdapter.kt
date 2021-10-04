package com.tamask.parliamentapp.constituencyList

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.tamask.parliamentapp.R

class ConstituencyListAdapter: RecyclerView.Adapter<ConstituencyListAdapter.MyViewHolder>() {

    private var constituencyList = emptyList<String>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.filter_item,
        parent, false))
    }

    override fun getItemCount(): Int {
        return constituencyList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = constituencyList[position]
        holder.itemView.findViewById<TextView>(R.id.title).text = currentItem

        holder.itemView.setOnClickListener {mView ->
            val direction = ConstituencyListFragmentDirections
                .actionConstituencyListFragmentToFilteredMemberListFragment("unknown", currentItem)
            mView.findNavController().navigate(direction)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(parties: List<String>){
        this.constituencyList = parties
        notifyDataSetChanged()
    }

}