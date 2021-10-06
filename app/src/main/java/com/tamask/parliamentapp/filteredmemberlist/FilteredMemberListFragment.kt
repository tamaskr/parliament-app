package com.tamask.parliamentapp.filteredmemberlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.tamask.parliamentapp.databinding.FilteredMemberListFragmentBinding

class FilteredMemberListFragment : Fragment() {

    private lateinit var filteredMemberListBinding: FilteredMemberListFragmentBinding
    private lateinit var filteredMemberListViewModel: FilteredMemberListViewModel
    private lateinit var filteredMemberListAdapter: FilteredMemberListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val args: FilteredMemberListFragmentArgs by navArgs()
        val party: String = args.party
        val const: String = args.constituency
        val unknown = "unknown"

        filteredMemberListBinding = FilteredMemberListFragmentBinding.inflate(inflater, container, false)
        filteredMemberListViewModel = ViewModelProvider(this).get(FilteredMemberListViewModel::class.java)

        filteredMemberListAdapter = FilteredMemberListAdapter()
        filteredMemberListBinding.recyclerview.adapter = filteredMemberListAdapter
        filteredMemberListBinding.recyclerview.layoutManager = LinearLayoutManager(this.context)

        if(const == unknown){
            filteredMemberListViewModel.getPartyMembers(party).observe(this, { member ->
                filteredMemberListAdapter.setData(member)
            })
        }else if(party == unknown){
            filteredMemberListViewModel.getConstituencyMembers(const).observe(this, { member ->
                filteredMemberListAdapter.setData(member)
            })
        }

        return filteredMemberListBinding.root
    }
}