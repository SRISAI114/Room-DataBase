package com.example.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var edtTxt: EditText
    private lateinit var btn: Button
    private lateinit var floatingBtn: ExtendedFloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtTxt = findViewById(R.id.edtTxt)
        btn = findViewById(R.id.btn)
        floatingBtn = findViewById(R.id.floatingBtn)
        btn.setOnClickListener {
            val data = RoomDBEntity(0, edtTxt.text.toString())
            val isSuccess = RoomDBDatabase.roomDB.roomDBDao().insertData(data)
            if (isSuccess > 0) {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }
        }
        floatingBtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}