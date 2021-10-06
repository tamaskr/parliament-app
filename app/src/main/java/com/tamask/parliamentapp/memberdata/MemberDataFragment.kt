package com.tamask.parliamentapp.memberdata

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.tamask.parliamentapp.databinding.MemberDataFragmentBinding
import com.tamask.parliamentapp.filteredmemberlist.FilteredMemberListAdapter
import com.tamask.parliamentapp.partylist.PartyListAdapter

class MemberDataFragment : Fragment() {

    private lateinit var memberDataViewModel: MemberDataViewModel
    private lateinit var memberDataBinding: MemberDataFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val args: MemberDataFragmentArgs by navArgs()
        val id: Int = args.id

        memberDataBinding = MemberDataFragmentBinding.inflate(inflater, container, false)
        memberDataViewModel = ViewModelProvider(this).get(MemberDataViewModel::class.java)

        memberDataViewModel.getMember(id).observe(this, { member ->
            memberDataBinding.name.text = FilteredMemberListAdapter().fullName(member.first, member.last)
            memberDataBinding.constituency.text = member.constituency
            memberDataBinding.party.text = PartyListAdapter().checkParty(member.party)
            memberDataBinding.minister.text = FilteredMemberListAdapter().checkMinister(member.minister)
            memberDataBinding.age.text = checkAge(member.bornYear)
        })

        return memberDataBinding.root
    }

    private fun checkAge(bornYear: Int) = "${2021-bornYear} years old"
}