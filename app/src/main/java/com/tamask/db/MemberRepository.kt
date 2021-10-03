package com.tamask.db

import androidx.lifecycle.LiveData

class MemberRepository(
    private val memberDAO: MemberDAO
) {

    fun getAllMembers(): LiveData<List<Member>> = memberDAO.getAllMembers()
    fun getParties(): LiveData<List<String>> = memberDAO.getParties()

    fun addMember(member: Member){
        memberDAO.addMember(member)
    }

    fun getPartyMembers(party: String): LiveData<List<Member>> {
        return memberDAO.getPartyMembers(party)
    }
}