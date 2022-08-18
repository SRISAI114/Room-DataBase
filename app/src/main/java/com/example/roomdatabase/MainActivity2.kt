package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = AdapterRoom()
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.myClickListener(object : AdapterRoom.MyClickListener{
            override fun itemClick(roomDBEntity: RoomDBEntity, position : Int) {
                RoomDBDatabase.roomDB.roomDBDao().deleteData(roomDBEntity.id)
                val array = RoomDBDatabase.roomDB.roomDBDao().selectData() as ArrayList<RoomDBEntity>
                adapter.addArray(array)
//                adapter.notifyItemRemoved(position)
            }
        })
        recyclerView.adapter = adapter
        val array = RoomDBDatabase.roomDB.roomDBDao().selectData() as ArrayList<RoomDBEntity>
        adapter.addArray(array)

    }
}