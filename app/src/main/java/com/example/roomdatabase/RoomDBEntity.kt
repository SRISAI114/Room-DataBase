package com.example.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RoomDBEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int ,
                   val name : String
) {
}