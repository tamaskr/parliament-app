package com.tamask.db

import androidx.lifecycle.LiveData

class MemberRepository(
    private val memberDAO: MemberDAO
) {
    fun getAllMembers(): LiveData<List<Member>> = memberDAO.getAllMembers()
    //fun getParties(): LiveData<Set<String>> = memberDatabase.memberDAO().getParties()

    fun addMember(member: Member){
        memberDAO.addMember(member)
    }
}