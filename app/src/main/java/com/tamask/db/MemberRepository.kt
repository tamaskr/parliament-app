package com.tamask.db

import androidx.lifecycle.LiveData

class MemberRepository(
    private val memberDAO: MemberDAO
) {

    fun getParties(): LiveData<List<String>> = memberDAO.getParties()
    fun getConstituencies(): LiveData<List<String>> = memberDAO.getConstituencies()

    fun addMember(member: Member){
        memberDAO.addMember(member)
    }

    fun getPartyMembers(party: String): LiveData<List<Member>> {
        return memberDAO.getPartyMembers(party)
    }

    fun getConsituencyMembers(constituency: String): LiveData<List<Member>> {
        return memberDAO.getConstituencyMembers(constituency)
    }

    fun getMember(id: Int): LiveData<Member> {
        return memberDAO.getMember(id)
    }
}