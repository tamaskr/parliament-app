package com.tamask.parliamentapp.filteredmemberlist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.tamask.db.Member
import com.tamask.db.MemberDatabase
import com.tamask.db.MemberRepository

class FilteredMemberListViewModel(application: Application): AndroidViewModel(application) {

    private val repository: MemberRepository

    init{
        val memberDao = MemberDatabase.getDatabase(application).memberDAO()
        repository = MemberRepository(memberDao, database = MemberDatabase.getDatabase(application))
    }

    fun getPartyMembers(party: String): LiveData<List<Member>>{
        return repository.getPartyMembers(party)
    }

    fun getConstituencyMembers(const: String): LiveData<List<Member>>{
        return repository.getConstituencyMembers(const)
    }
}