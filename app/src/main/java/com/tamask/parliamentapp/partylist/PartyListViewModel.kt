package com.tamask.parliamentapp.partylist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tamask.db.Member
import com.tamask.db.MemberDatabase
import com.tamask.db.MemberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PartyListViewModel(application: Application): AndroidViewModel(application){

    val getParties: LiveData<List<String>>
    private val repository: MemberRepository

    init{
        val memberDao = MemberDatabase.getDatabase(application).memberDAO()
        repository = MemberRepository(memberDao)
        getParties = repository.getParties()
    }

    //fun addMember(member: Member){
    //    viewModelScope.launch (Dispatchers.IO){
    //        repository.addMember(member)
    //    }
    //}
}