package com.example.roomdatabase

import android.app.Application
import android.content.Context

//1.Public constructors
//2.Base class for maintaining global application state.
//You can provide your own implementation by creating a subclass and specifying ,
//the fully-qualified name of this subclass as the "android:name" attribute in your AndroidManifest.xml's <application> tag.
class MyApplicationContext : Application() {


    init {
        //here this represents MyApplicationContext

        myApplicationContext = this
    }
    companion object{
        private lateinit var myApplicationContext : Application

        fun applicationContext() : Context
        {
            return myApplicationContext
        }
    }

}