package com.tamask.parliamentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.tamask.parliamentapp.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getView()?.findViewById<Button>(R.id.party_button)?.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_partyListFragment)
        }

        getView()?.findViewById<Button>(R.id.const_button)?.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_constituencyListFragment)
        }
    }
}