package com.example.finalpahrul.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.example.finalpahrul.entity.Student



@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
}