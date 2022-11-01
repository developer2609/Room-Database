package com.example.roomdatabase.Db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

  @Database(entities = [MyContact::class], version = 1)

abstract  class AppDabase :RoomDatabase(){

    abstract fun myContactDao():MyContactDao

    companion object{
      private var appDabase:AppDabase?=null

      @Synchronized
      fun getInstance(context: Context):AppDabase{
        if (appDabase==null){
          appDabase=Room.databaseBuilder(context,AppDabase::class.java,"contact")
              .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
        }
        return appDabase!!
      }
    }

}