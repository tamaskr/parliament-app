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

    @Query("SELECT DISTINCT party FROM member_table ORDER BY party ASC")
    fun getParties(): LiveData<List<String>>

    @Query("SELECT DISTINCT constituency FROM member_table ORDER BY constituency ASC")
    fun getConstituencies(): LiveData<List<String>>

    @Query("SELECT * FROM member_table WHERE party LIKE :party ORDER BY party ASC")
    fun getPartyMembers(party: String): LiveData<List<Member>>

    @Query("SELECT * FROM member_table WHERE constituency LIKE :constituency ORDER BY first ASC")
    fun getConstituencyMembers(constituency: String): LiveData<List<Member>>

    @Query("SELECT * FROM member_table WHERE personNumber LIKE :id")
    fun getMember(id: Int): LiveData<Member>

    @Query("SELECT * FROM member_table ORDER BY first ASC")
    fun getAllMembers(): LiveData<List<Member>>
}