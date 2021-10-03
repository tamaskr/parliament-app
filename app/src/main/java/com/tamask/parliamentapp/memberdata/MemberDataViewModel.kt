package com.tamask.parliamentapp.memberdata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.tamask.db.Member
import com.tamask.db.MemberDatabase
import com.tamask.db.MemberRepository

class MemberDataViewModel(application: Application): AndroidViewModel(application) {

    private val repository: MemberRepository

    init{
        val memberDao = MemberDatabase.getDatabase(application).memberDAO()
        repository = MemberRepository(memberDao)
    }

    fun getMember(id: Int): LiveData<Member> {
        return repository.getMember(id)
    }
}