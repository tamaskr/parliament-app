package com.tamask.parliamentapp.filteredmemberlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.tamask.db.Member
import com.tamask.parliamentapp.R
import com.tamask.parliamentapp.partylist.PartyListFragmentDirections

class FilteredMemberListAdapter: RecyclerView.Adapter<FilteredMemberListAdapter.MyViewHolder>() {

    private var memberList = emptyList<Member>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.member_item,
        parent, false))
    }

    override fun getItemCount(): Int {
        return memberList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = memberList[position]
        holder.itemView.findViewById<TextView>(R.id.name).text = fullName(currentItem.first, currentItem.last)
        holder.itemView.findViewById<TextView>(R.id.memberOrMinister).text = checkMinister(currentItem.minister)
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

    private fun fullName(first: String, last: String) = "$first $last"

    private fun checkMinister(isMinister: Boolean) = if(isMinister) "Minister" else "Member"

}