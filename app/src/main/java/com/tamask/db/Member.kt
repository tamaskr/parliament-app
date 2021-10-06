package com.tamask.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

// data class MemberRecords (val records:List<Member>)

//@JsonClass(generateAdapter = true)
@Entity(tableName = "member_table")
data class Member(
    @PrimaryKey
    //@Json(name = "personNumber")
    val personNumber: Int,
    //@Json(name = "seatNumber")
    val seatNumber: Int,
    //@Json(name = "last")
    val last: String,
    //@Json(name = "first")
    val first: String,
    //@Json(name = "party")
    val party: String,
    //@Json(name = "minister")
    val minister: Boolean,
    //@Json(name = "picture")
    val picture: String,
    //@Json(name = "twitter")
    val twitter: String,
    //@Json(name = "bornYear")
    val bornYear: Int,
    //@Json(name = "constituency")
    val constituency: String
)

