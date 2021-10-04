package com.tamask.parliamentapp.constituencyList

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
import androidx.recyclerview.widget.LinearLayoutManager
import com.tamask.parliamentapp.R
import com.tamask.parliamentapp.databinding.PartyListFragmentBinding

class ConstituencyListFragment : Fragment() {

    private lateinit var constituencyListBinding: PartyListFragmentBinding
    private lateinit var constituencyListViewModel: ConstituencyListViewModel
    private lateinit var constituencyListAdapter: ConstituencyListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)

        constituencyListBinding = PartyListFragmentBinding.inflate(inflater, container, false)
        constituencyListViewModel = ViewModelProvider(this).get(ConstituencyListViewModel::class.java)

        constituencyListAdapter = ConstituencyListAdapter()
        constituencyListBinding.recyclerview.adapter = constituencyListAdapter
        constituencyListBinding.recyclerview.layoutManager = LinearLayoutManager(this.context)

        constituencyListViewModel.getConstituencies.observe(viewLifecycleOwner, Observer { constituencies ->
            constituencyListAdapter.setData(constituencies)
        })

        val callback = object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.action_constituencyListFragment_to_home2)
            }
        }
        return constituencyListBinding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home ->
                findNavController().navigate(R.id.action_constituencyListFragment_to_home2)
        }
        return true
    }

}