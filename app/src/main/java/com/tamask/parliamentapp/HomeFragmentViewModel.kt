package com.tamask.parliamentapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tamask.db.Member
import com.tamask.db.MemberAPI
import com.tamask.db.MemberDatabase
import com.tamask.db.MemberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragmentViewModel(application: Application): AndroidViewModel(application) {

    private val _members = MutableLiveData<List<Member>>()

    val members: LiveData<List<Member>>
        get() = _members

    private val repository: MemberRepository

    init {
        val memberDao = MemberDatabase.getDatabase(application).memberDAO()
        repository = MemberRepository(memberDao)
        getAllMembers()
    }

    private fun getAllMembers() {
        viewModelScope.launch {
            try {
                _members.value = MemberAPI.retrofitService.getMembers()
            } catch (e: Exception) {
                _members.value = ArrayList()
            }
        }
    }

    fun addAllMembers(members: List<Member>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addAllMembers(members)
        }
    }
}