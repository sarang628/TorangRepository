package com.sryang.torang_repository.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sryang.torang_repository.data.dao.AlarmDao
import com.sryang.torang_repository.data.dao.CommentDao
import com.sryang.torang_repository.data.dao.FeedDao
import com.sryang.torang_repository.data.dao.LoggedInUserDao
import com.sryang.torang_repository.data.dao.MenuDao
import com.sryang.torang_repository.data.dao.MyReviewDao
import com.sryang.torang_repository.data.dao.PictureDao
import com.sryang.torang_repository.data.dao.RestaurantDao
import com.sryang.torang_repository.data.dao.ReviewDao
import com.sryang.torang_repository.data.dao.SearchDao
import com.sryang.torang_repository.data.dao.UserDao
import com.sryang.torang_repository.data.entity.AlarmEntity
import com.sryang.torang_repository.data.entity.CommentEntity
import com.sryang.torang_repository.data.entity.FavoriteEntity
import com.sryang.torang_repository.data.entity.FeedEntity
import com.sryang.torang_repository.data.entity.LikeEntity
import com.sryang.torang_repository.data.entity.LoggedInUserEntity
import com.sryang.torang_repository.data.entity.MenuEntity
import com.sryang.torang_repository.data.entity.RestaurantEntity
import com.sryang.torang_repository.data.entity.ReviewImageEntity
import com.sryang.torang_repository.data.entity.SearchEntity
import com.sryang.torang_repository.data.entity.UserEntity


/**
 * The Room database for this app
 */
//@Database(
//    entities = [
//        UserEntity::class, FeedEntity::class, ReviewImageEntity::class, LikeEntity::class,
//        RestaurantEntity::class, MenuEntity::class, AlarmEntity::class,
//        LoggedInUserEntity::class, SearchEntity::class, FavoriteEntity::class, CommentEntity::class
//    ], version = 1, exportSchema = false
//)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun userDao(): UserDao
//    abstract fun restaurantDao(): RestaurantDao
//    abstract fun reviewDao(): ReviewDao
//    abstract fun menuDao(): MenuDao
//    abstract fun alarmDao(): AlarmDao
//    abstract fun myReviewDao(): MyReviewDao
//    abstract fun LoggedInUserDao(): LoggedInUserDao
//    abstract fun searchDao(): SearchDao
//    abstract fun pictureDao(): PictureDao
//    abstract fun feedDao(): FeedDao
//    abstract fun commentDao(): CommentDao
//
//    companion object {
//        // For Singleton instantiation
//        @Volatile
//        private var instance: AppDatabase? = null
//
//        fun getInstance(context: Context): AppDatabase {
//            return instance ?: synchronized(this) {
//                instance ?: buildDatabase(context).also { instance = it }
//            }
//        }
//
//        private fun buildDatabase(context: Context): AppDatabase {
//            return Room.databaseBuilder(
//                context, AppDatabase::class.java,
//                "DATABASE_NAME"
//            )
//                .addCallback(
//                    object : Callback() {
//                    }
//                )
//                .build()
//        }
//    }
//}
