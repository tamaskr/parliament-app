package com.tamask.parliamentapp.memberdata

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.tamask.parliamentapp.databinding.MemberDataFragmentBinding
import com.tamask.parliamentapp.partylist.PartyListAdapter

class MemberDataFragment : Fragment() {

    private lateinit var memberDataViewModel: MemberDataViewModel
    private lateinit var memberDataBinding: MemberDataFragmentBinding

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val args: MemberDataFragmentArgs by navArgs()
        val id: Int = args.id

        memberDataBinding = MemberDataFragmentBinding.inflate(inflater, container, false)
        memberDataViewModel = ViewModelProvider(this).get(MemberDataViewModel::class.java)

        memberDataViewModel.getMember(id).observe(viewLifecycleOwner, Observer { member ->
            memberDataBinding.name.text = "${member.first} ${member.last}"
            memberDataBinding.constituency.text = member.constituency
            memberDataBinding.party.text = PartyListAdapter().checkParty(member.party)
            memberDataBinding.minister.text = if(member.minister) "Minister" else "Member of parliament"
            memberDataBinding.age.text = "${2021-member.bornYear} years old"
        })

        return memberDataBinding.root
    }
}