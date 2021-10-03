package com.tamask.parliamentapp.memberdata

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tamask.parliamentapp.R

class MemberDataFragment : Fragment() {

    companion object {
        fun newInstance() = MemberDataFragment()
    }

    private lateinit var viewModel: MemberDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.member_data_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MemberDataViewModel::class.java)
        // TODO: Use the ViewModel
    }

}