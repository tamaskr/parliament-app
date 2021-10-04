package com.tamask.parliamentapp.filteredmemberlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.tamask.parliamentapp.R
import com.tamask.parliamentapp.databinding.FilteredMemberListFragmentBinding

class FilteredMemberListFragment : Fragment() {

    private lateinit var filteredMemberListBinding: FilteredMemberListFragmentBinding
    private lateinit var filteredMemberListViewModel: FilteredMemberListViewModel
    private lateinit var filteredMemberListAdapter: FilteredMemberListAdapter

    var isFilteredByParty: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

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
            filteredMemberListViewModel.getPartyMembers(party).observe(viewLifecycleOwner, Observer { member ->
                filteredMemberListAdapter.setData(member)
                isFilteredByParty = true
            })
        }else if(party == unknown){
            filteredMemberListViewModel.getConstituencyMembers(const).observe(viewLifecycleOwner, Observer { member ->
                filteredMemberListAdapter.setData(member)
                isFilteredByParty = false
            })
        }

        val callback = object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if(isFilteredByParty){
                    findNavController().navigate(R.id.action_filteredMemberListFragment_to_partyListFragment)
                }else{
                    findNavController().navigate(R.id.action_filteredMemberListFragment_to_constituencyListFragment)
                }
            }
        }
        return filteredMemberListBinding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(isFilteredByParty){
            findNavController().navigate(R.id.action_filteredMemberListFragment_to_partyListFragment)
        }else{
            findNavController().navigate(R.id.action_filteredMemberListFragment_to_constituencyListFragment)
        }
        return true
    }

}