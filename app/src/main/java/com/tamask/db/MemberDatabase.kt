package com.tamask.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import okhttp3.internal.Internal.instance

@Database(
    entities = [Member::class],
    version = 1,
    exportSchema = false
)

abstract class MemberDatabase: RoomDatabase() {

    abstract fun memberDAO(): MemberDAO

    companion object {
        private const val DB_NAME = "member_database"

        @Volatile
        private var INSTANCE: MemberDatabase? = null
        private val LOCK = Any()

        fun getDatabase(context: Context): MemberDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) return tempInstance

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MemberDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}