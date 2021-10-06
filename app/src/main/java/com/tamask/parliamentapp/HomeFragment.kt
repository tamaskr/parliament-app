package com.tamask.parliamentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tamask.db.Member
import com.tamask.parliamentapp.databinding.HomeFragmentBinding
import com.tamask.parliamentapp.partylist.PartyListViewModel
import java.nio.file.Files.size

class HomeFragment : Fragment() {

    private lateinit var homeFragmentViewModel: HomeFragmentViewModel
    private lateinit var homeFragmentBinding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        homeFragmentBinding = HomeFragmentBinding.inflate(inflater, container, false)
        homeFragmentViewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)

        homeFragmentBinding.viewModel = homeFragmentViewModel

        homeFragmentViewModel.members.observe(viewLifecycleOwner){
            val tempMembers: List<Member>? = homeFragmentViewModel.members.value
            if (tempMembers != null)  homeFragmentViewModel.addAllMembers(tempMembers)
        }

        homeFragmentBinding.partyButton.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_partyListFragment)
        }

        homeFragmentBinding.constButton.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_constituencyListFragment)
        }

        return homeFragmentBinding.root
    }
}