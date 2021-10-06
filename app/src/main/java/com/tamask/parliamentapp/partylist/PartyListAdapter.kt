package com.tamask.parliamentapp.partylist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.tamask.parliamentapp.databinding.FilterItemBinding

class PartyListAdapter: RecyclerView.Adapter<PartyListAdapter.ViewHolder>() {

    private var partyList = emptyList<String>()

    inner class ViewHolder(val partyListAdapterBinding: FilterItemBinding) :
        RecyclerView.ViewHolder(partyListAdapterBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FilterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return partyList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = partyList[position]
        holder.partyListAdapterBinding.title.text = checkParty(currentItem)

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