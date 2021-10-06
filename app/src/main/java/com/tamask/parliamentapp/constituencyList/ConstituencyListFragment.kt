package com.tamask.parliamentapp.constituencyList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tamask.parliamentapp.databinding.PartyListFragmentBinding

class ConstituencyListFragment : Fragment() {

    private lateinit var constituencyListBinding: PartyListFragmentBinding
    private lateinit var constituencyListViewModel: ConstituencyListViewModel
    private lateinit var constituencyListAdapter: ConstituencyListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        constituencyListBinding = PartyListFragmentBinding.inflate(inflater, container, false)
        constituencyListViewModel = ViewModelProvider(this).get(ConstituencyListViewModel::class.java)

        constituencyListAdapter = ConstituencyListAdapter()
        constituencyListBinding.recyclerview.adapter = constituencyListAdapter
        constituencyListBinding.recyclerview.layoutManager = LinearLayoutManager(this.context)

        constituencyListViewModel.getConstituencies.observe(viewLifecycleOwner, { constituencies ->
            constituencyListAdapter.setData(constituencies)
        })

        return constituencyListBinding.root
    }
}