package com.tamask.parliamentapp.partylist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tamask.parliamentapp.R

class PartyListFragment : Fragment() {

    companion object {
        fun newInstance() = PartyListFragment()
    }

    private lateinit var viewModel: PartyListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.party_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PartyListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}