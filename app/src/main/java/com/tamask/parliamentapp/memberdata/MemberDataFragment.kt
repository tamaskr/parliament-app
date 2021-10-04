package com.tamask.parliamentapp.memberdata

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tamask.parliamentapp.databinding.MemberDataFragmentBinding
import com.tamask.parliamentapp.filteredmemberlist.FilteredMemberListFragment

class MemberDataFragment : Fragment() {

    private lateinit var memberDataViewModel: MemberDataViewModel
    private lateinit var memberDataBinding: MemberDataFragmentBinding
    private var party: String = ""
    private var const: String = ""
    val unknown: String = "unknown"

    var isFilteredByParty: Boolean = FilteredMemberListFragment().isFilteredByParty

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)

        val args: MemberDataFragmentArgs by navArgs()
        val id: Int = args.id

        memberDataBinding = MemberDataFragmentBinding.inflate(inflater, container, false)
        memberDataViewModel = ViewModelProvider(this).get(MemberDataViewModel::class.java)

        memberDataViewModel.getMember(id).observe(viewLifecycleOwner, Observer { member ->
            memberDataBinding.name.text = "${member.first} ${member.last}"
            memberDataBinding.constituency.text = member.constituency
            memberDataBinding.party.text = checkParty(member.party)
            memberDataBinding.minister.text = if(member.minister) "Minister" else "Member of parliament"
            memberDataBinding.age.text = "${2021-member.bornYear} years old"
            party = member.party
            const = member.constituency
        })

        val callback = object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if(isFilteredByParty){
                    val direction = MemberDataFragmentDirections
                        .actionMemberDataFragment2ToFilteredMemberListFragment(party, unknown)
                    findNavController().navigate(direction)
                }else{
                    val direction = MemberDataFragmentDirections
                        .actionMemberDataFragment2ToFilteredMemberListFragment(unknown, const)
                    findNavController().navigate(direction)
                }
            }
        }
        return memberDataBinding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(isFilteredByParty){
            val direction = MemberDataFragmentDirections
                .actionMemberDataFragment2ToFilteredMemberListFragment(party, unknown)
            findNavController().navigate(direction)
        }else{
            val direction = MemberDataFragmentDirections
                .actionMemberDataFragment2ToFilteredMemberListFragment(unknown, const)
            findNavController().navigate(direction)
        }
        return true
    }

    fun checkParty(party: String): String{
        val partyName = when(party){
            "sd" -> "Social Democratic Party"
            "ps" -> "Finns Party"
            "kok" -> "National Coalition Party"
            "kesk" -> "Centre Party"
            "vihr" -> "Green League"
            "vas" -> "Left Alliance"
            "r" -> "Swedish People's Party"
            "kd" -> "Christian Democrats"
            "liik" -> "Movement Now"
            else -> "Unknown party"
        }
        return partyName
    }
}