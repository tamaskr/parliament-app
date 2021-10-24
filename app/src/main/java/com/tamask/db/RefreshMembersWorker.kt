package com.tamask.db

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.tamask.db.MemberDatabase.Companion.getDatabase
import retrofit2.HttpException

class RefreshMembersWorker(appContext: Context, params: WorkerParameters) :
    CoroutineWorker(appContext, params) {

    companion object {
        const val WORK_NAME = "com.tamask.db.RefreshMembersWorker"
    }
    override suspend fun doWork(): Result {
        val database = getDatabase(applicationContext)
        val memberDao = database.memberDAO()
        val repository = MemberRepository(memberDao, database)


        try {
            repository.refreshMembers()
        } catch (e: HttpException) {
            return Result.retry()
        }

        return Result.success()
    }
}