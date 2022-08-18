package com.example.roomdatabase

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RoomDBEntity::class], version = 1)
abstract class RoomDBDatabase : RoomDatabase()  {

    abstract fun roomDBDao() : RoomDBRao

    companion object{
        val roomDB = Room.databaseBuilder(MyApplicationContext.applicationContext(),
        RoomDBDatabase::class.java,"ONE").allowMainThreadQueries().build()
    }


}