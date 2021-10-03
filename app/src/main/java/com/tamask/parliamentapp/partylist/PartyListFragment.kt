package com.tamask.parliamentapp.partylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tamask.db.Member
import com.tamask.parliamentapp.R

class PartyListFragment : Fragment() {

    companion object {
        fun newInstance() = PartyListFragment()
    }

    private lateinit var partListViewModel: PartyListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val view = inflater.inflate(R.layout.party_list_fragment, container, false)
        partListViewModel = ViewModelProvider(this).get(PartyListViewModel::class.java)

        partListViewModel.addMember(Member(54, 53, "Person", "One", "sd", false, "/valami/valami.jpg", "", 1956, "Helsinki"))
        partListViewModel.addMember(Member(55, 153, "Hello", "Two", "kdf", false, "/valami/valami.jpg", "", 1956, "Helsinki"))
        partListViewModel.addMember(Member(56, 353, "There", "Three", "xx", true, "/valami/valami.jpg", "", 1956, "Tampere"))
        partListViewModel.addMember(Member(57, 453, "Obi", "Four", "kdy", false, "/valami/valami.jpg", "", 1956, "Helsinki"))
        partListViewModel.addMember(Member(58, 553, "Wan", "Five", "sd", false, "/valami/valami.jpg", "", 1956, "Helsinki"))
        partListViewModel.addMember(Member(59, 653, "Kenobi", "Six", "kdf", false, "/valami/valami.jpg", "", 1956, "Tampere"))
        partListViewModel.addMember(Member(51, 753, "Yes", "Seven", "sd", true, "/valami/valami.jpg", "", 1956, "Helsinki"))
        partListViewModel.addMember(Member(50, 853, "No", "Eight", "trg", false, "/valami/valami.jpg", "", 1956, "Oulu"))

        val callback = object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.action_partyListFragment_to_home2)
            }
        }

        return view
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home ->
                findNavController().navigate(R.id.action_partyListFragment_to_home2)
        }
        return true
    }

}