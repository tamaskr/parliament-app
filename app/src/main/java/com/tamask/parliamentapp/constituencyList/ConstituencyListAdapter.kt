package com.tamask.parliamentapp.constituencyList

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.tamask.parliamentapp.databinding.FilterItemBinding

class ConstituencyListAdapter: RecyclerView.Adapter<ConstituencyListAdapter.ViewHolder>() {

    private var constituencyList = emptyList<String>()

    inner class ViewHolder(val constituencyListAdapterBinding: FilterItemBinding) :
        RecyclerView.ViewHolder(constituencyListAdapterBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FilterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return constituencyList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = constituencyList[position]
        holder.constituencyListAdapterBinding.title.text = currentItem

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