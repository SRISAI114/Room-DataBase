package com.example.roomdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface RoomDBRao {

    //Insert means data insert , when editText time
    @Insert
    fun insertData(roomDBEntity: RoomDBEntity): Long

    //shows for all data shows
    @Query("SELECT * FROM ROOMDBENTITY")
    fun selectData(): List<RoomDBEntity>


    //Delate for delate from our list
    @Query("DELETE FROM RoomDBEntity where id=:id")
    fun deleteData(id : Int)
}