package com.tamask.db

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MemberRepository(
    private val memberDAO: MemberDAO,
    private val database: MemberDatabase
) {

    fun getParties(): LiveData<List<String>> = memberDAO.getParties()

    fun getConstituencies(): LiveData<List<String>> = memberDAO.getConstituencies()

    fun getPartyMembers(party: String): LiveData<List<Member>> {
        return memberDAO.getPartyMembers(party)
    }

    fun getConstituencyMembers(constituency: String): LiveData<List<Member>> {
        return memberDAO.getConstituencyMembers(constituency)
    }

    fun getMember(id: Int): LiveData<Member> {
        return memberDAO.getMember(id)
    }

    fun addAllMembers(members: List<Member>) {
        return memberDAO.addAllMembers(members)
    }

    suspend fun refreshMembers() {
        withContext(Dispatchers.IO) {
            database.memberDAO().deleteAllMembers()
            val members = MemberAPI.retrofitService.getMembers()
            database.memberDAO().addAllMembers(members)
        }
    }
}