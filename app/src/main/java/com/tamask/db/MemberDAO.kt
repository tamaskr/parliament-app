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

    //@Query("SELECT party FROM member_table")
    //fun getParties(): LiveData<Set<String>>

    @Query("SELECT * FROM member_table")
    fun getAllMembers(): LiveData<List<Member>>
}