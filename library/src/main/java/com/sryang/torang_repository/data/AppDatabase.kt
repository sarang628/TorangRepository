package com.sryang.torang_repository.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sryang.torang_repository.data.entity.User
import com.sryang.torang_repository.data.entity.UserDao

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

/*
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: AppDatabase? = null

        */
/*fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context, AppDatabase::class.java,
                "DATABASE_NAME"
            )
                .addCallback(
                    object : Callback() {
                    }
                )
                .build()
        }*//*

    }
}
*/
