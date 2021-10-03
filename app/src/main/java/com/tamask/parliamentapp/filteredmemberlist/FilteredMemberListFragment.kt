package com.tamask.parliamentapp.filteredmemberlist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tamask.parliamentapp.R

class FilteredMemberListFragment : Fragment() {

    companion object {
        fun newInstance() = FilteredMemberListFragment()
    }

    private lateinit var viewModel: FilteredMemberListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.filtered_member_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FilteredMemberListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}