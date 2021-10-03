package com.tamask.parliamentapp.filteredmemberlist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tamask.db.Member
import com.tamask.db.MemberDatabase
import com.tamask.db.MemberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FilteredMemberListViewModel(application: Application): AndroidViewModel(application) {

    //private lateinit var partyMemberList: LiveData<List<Member>>
    private val repository: MemberRepository

    init{
        val memberDao = MemberDatabase.getDatabase(application).memberDAO()
        repository = MemberRepository(memberDao)
    }

    fun getPartyMembers(party: String): LiveData<List<Member>>{
        return repository.getPartyMembers(party)
    }
}