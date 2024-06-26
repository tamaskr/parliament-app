package com.tamask.parliamentapp.partylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tamask.db.Member
import com.tamask.parliamentapp.databinding.PartyListFragmentBinding

class PartyListFragment : Fragment() {

    private lateinit var partyListBinding: PartyListFragmentBinding
    private lateinit var partyListViewModel: PartyListViewModel
    private lateinit var partyListAdapter: PartyListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        partyListBinding = PartyListFragmentBinding.inflate(inflater, container, false)
        partyListViewModel = ViewModelProvider(this).get(PartyListViewModel::class.java)

        partyListAdapter = PartyListAdapter()
        partyListBinding.recyclerview.adapter = partyListAdapter
        partyListBinding.recyclerview.layoutManager = LinearLayoutManager(this.context)

        partyListViewModel.getParties.observe(viewLifecycleOwner, { parties ->
            partyListAdapter.setData(parties)
        })

        /*
        partyListViewModel.addMember(Member(54, 53, "Person", "One", "sd", false, "/valami/valami.jpg", "", 1956, "Helsinki"))
        partyListViewModel.addMember(Member(55, 153, "Hello", "Two", "kok", false, "/valami/valami.jpg", "", 1956, "Helsinki"))
        partyListViewModel.addMember(Member(56, 353, "There", "Three", "sd", true, "/valami/valami.jpg", "", 1956, "Tampere"))
        partyListViewModel.addMember(Member(57, 453, "Obi", "Four", "kok", false, "/valami/valami.jpg", "", 1956, "Helsinki"))
        partyListViewModel.addMember(Member(58, 553, "Wan", "Five", "sd", false, "/valami/valami.jpg", "", 1956, "Helsinki"))
        partyListViewModel.addMember(Member(59, 653, "Kenobi", "Six", "kesk", false, "/valami/valami.jpg", "", 1956, "Tampere"))
        partyListViewModel.addMember(Member(51, 753, "Yes", "Seven", "ps", true, "/valami/valami.jpg", "", 1956, "Helsinki"))
        partyListViewModel.addMember(Member(50, 853, "No", "Eight", "kesk", false, "/valami/valami.jpg", "", 1956, "Oulu"))
        */
        return partyListBinding.root
    }
}