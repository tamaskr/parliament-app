package com.tamask.parliamentapp.constituencyList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.tamask.db.MemberDatabase
import com.tamask.db.MemberRepository

class ConstituencyListViewModel(application: Application): AndroidViewModel(application){

    val getConstituencies: LiveData<List<String>>
    private val repository: MemberRepository

    init{
        val memberDao = MemberDatabase.getDatabase(application).memberDAO()
        repository = MemberRepository(memberDao, database = MemberDatabase.getDatabase(application))
        getConstituencies = repository.getConstituencies()
    }
}