package com.tamask.parliamentapp.filteredmemberlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tamask.db.Member
import com.tamask.parliamentapp.R
import com.tamask.parliamentapp.databinding.MemberItemBinding

class FilteredMemberListAdapter: RecyclerView.Adapter<FilteredMemberListAdapter.ViewHolder>() {

    private var memberList = emptyList<Member>()
    private val BASE_URL = "https://avoindata.eduskunta.fi/"

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

        Glide.with(holder.itemView.context)
            .asBitmap()
            .load(BASE_URL + currentItem.picture)
            .into(holder.filteredMemberListAdapterBinding.image)

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(members: List<Member>){
        this.memberList = members
        notifyDataSetChanged()
    }

    fun fullName(first: String, last: String) = "$first $last"

    fun checkMinister(isMinister: Boolean) = if(isMinister) "Minister" else "Member"

    //@BindingAdapter("imageUrl")
    private fun bindImage(imgView: ImageView, imgUrl: String) {
        imgUrl.let {
            val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
            Glide.with(imgView.context)
                .load(imgUri)
                .apply(RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background))
                .into(imgView)
        }
    }

}