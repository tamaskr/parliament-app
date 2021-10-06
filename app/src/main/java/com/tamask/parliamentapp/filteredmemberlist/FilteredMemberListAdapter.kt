package com.tamask.parliamentapp.filteredmemberlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.tamask.db.Member
import com.tamask.parliamentapp.databinding.MemberItemBinding

class FilteredMemberListAdapter: RecyclerView.Adapter<FilteredMemberListAdapter.ViewHolder>() {

    private var memberList = emptyList<Member>()

    inner class ViewHolder(val filteredMemberListAdapterBinding: MemberItemBinding) :
        RecyclerView.ViewHolder(filteredMemberListAdapterBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MemberItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return memberList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = memberList[position]
        holder.filteredMemberListAdapterBinding.name.text = fullName(currentItem.first, currentItem.last)
        holder.filteredMemberListAdapterBinding.memberOrMinister.text = checkMinister(currentItem.minister)
        holder.itemView.setOnClickListener {mView ->
            val direction = FilteredMemberListFragmentDirections
                .actionFilteredMemberListFragmentToMemberDataFragment2(currentItem.personNumber)
            mView.findNavController().navigate(direction)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(members: List<Member>){
        this.memberList = members
        notifyDataSetChanged()
    }

    fun fullName(first: String, last: String) = "$first $last"

    fun checkMinister(isMinister: Boolean) = if(isMinister) "Minister" else "Member"

}