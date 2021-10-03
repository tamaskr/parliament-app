package com.tamask.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mps")
data class Member (
    @PrimaryKey //@ColumnInfo(name = "personNumber")
        val personNumber: Int,
    //@ColumnInfo(name = "seatNumber")
        val seatNumber: Int,
    //@ColumnInfo(name = "last")
        val last: String,
    //@ColumnInfo(name = "first")
        val first: String,
    //@ColumnInfo(name = "party")
        val party: String,
    //@ColumnInfo(name = "minister")
        val minister: Boolean,
    //@ColumnInfo(name = "picture")
        val picture: String,
    //@ColumnInfo(name = "twitter")
        val twitter: String,
    //@ColumnInfo(name = "bornYear")
        val bornYear: Int,
    //@ColumnInfo(name = "constituency")
        val constituency: String
)