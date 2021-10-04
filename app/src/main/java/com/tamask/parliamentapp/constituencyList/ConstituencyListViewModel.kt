package com.tamask.parliamentapp.constituencyList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tamask.db.Member
import com.tamask.db.MemberDatabase
import com.tamask.db.MemberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConstituencyListViewModel(application: Application): AndroidViewModel(application){

    val getConstituencies: LiveData<List<String>>
    private val repository: MemberRepository

    init{
        val memberDao = MemberDatabase.getDatabase(application).memberDAO()
        repository = MemberRepository(memberDao)
        getConstituencies = repository.getConstituencies()
    }

}