package com.tamask.parliamentapp.partylist

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
import com.tamask.db.Member
import com.tamask.parliamentapp.R
import com.tamask.parliamentapp.databinding.PartyListFragmentBinding

class PartyListFragment : Fragment() {

    private lateinit var partyListBinding: PartyListFragmentBinding
    private lateinit var partyListViewModel: PartyListViewModel
    private lateinit var partListAdapter: PartyListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)

        partyListBinding = PartyListFragmentBinding.inflate(inflater, container, false)
        partyListViewModel = ViewModelProvider(this).get(PartyListViewModel::class.java)

        partListAdapter = PartyListAdapter()
        partyListBinding.recyclerview.adapter = partListAdapter
        partyListBinding.recyclerview.layoutManager = LinearLayoutManager(this.context)

        partyListViewModel.getParties.observe(viewLifecycleOwner, Observer { parties ->
            partListAdapter.setData(parties)
        })

        partyListViewModel.addMember(Member(54, 53, "Person", "One", "sd", false, "/valami/valami.jpg", "", 1956, "Helsinki"))
        partyListViewModel.addMember(Member(55, 153, "Hello", "Two", "kok", false, "/valami/valami.jpg", "", 1956, "Helsinki"))
        partyListViewModel.addMember(Member(56, 353, "There", "Three", "sd", true, "/valami/valami.jpg", "", 1956, "Tampere"))
        partyListViewModel.addMember(Member(57, 453, "Obi", "Four", "kok", false, "/valami/valami.jpg", "", 1956, "Helsinki"))
        partyListViewModel.addMember(Member(58, 553, "Wan", "Five", "sd", false, "/valami/valami.jpg", "", 1956, "Helsinki"))
        partyListViewModel.addMember(Member(59, 653, "Kenobi", "Six", "kesk", false, "/valami/valami.jpg", "", 1956, "Tampere"))
        partyListViewModel.addMember(Member(51, 753, "Yes", "Seven", "ps", true, "/valami/valami.jpg", "", 1956, "Helsinki"))
        partyListViewModel.addMember(Member(50, 853, "No", "Eight", "kesk", false, "/valami/valami.jpg", "", 1956, "Oulu"))

        val callback = object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.action_partyListFragment_to_home2)
            }
        }
        return partyListBinding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home ->
                findNavController().navigate(R.id.action_partyListFragment_to_home2)
        }
        return true
    }

}