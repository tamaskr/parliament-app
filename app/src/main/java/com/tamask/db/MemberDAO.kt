package com.tamask.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MemberDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addMember(member: Member)

    @Query("SELECT DISTINCT party FROM member_table ")
    fun getParties(): LiveData<List<String>>

    @Query("SELECT * FROM member_table WHERE party LIKE :party")
    fun getPartyMembers(party: String): LiveData<List<Member>>

    @Query("SELECT * FROM member_table")
    fun getAllMembers(): LiveData<List<Member>>
}