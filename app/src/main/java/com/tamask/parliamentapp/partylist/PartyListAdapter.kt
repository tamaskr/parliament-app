package com.tamask.parliamentapp.partylist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.tamask.parliamentapp.R

class PartyListAdapter: RecyclerView.Adapter<PartyListAdapter.MyViewHolder>() {

    private var partyList = emptyList<String>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.filter_item,
        parent, false))
    }

    override fun getItemCount(): Int {
        return partyList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = partyList[position]
        holder.itemView.findViewById<TextView>(R.id.title).text = checkParty(currentItem)

        holder.itemView.setOnClickListener {mView ->
            val direction = PartyListFragmentDirections
                .actionPartyListFragmentToFilteredMemberListFragment(currentItem, "unknown")
            mView.findNavController().navigate(direction)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(parties: List<String>){
        this.partyList = parties
        notifyDataSetChanged()
    }

    fun checkParty(party: String): String{
        val partyName = when(party){
            "sd" -> "Social Democratic Party"
            "ps" -> "Finns Party"
            "kok" -> "National Coalition Party"
            "kesk" -> "Centre Party"
            "vihr" -> "Green League"
            "vas" -> "Left Alliance"
            "r" -> "Swedish People's Party"
            "kd" -> "Christian Democrats"
            "liik" -> "Movement Now"
            else -> "Unknown party"
        }
        return partyName
    }

}