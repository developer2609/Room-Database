package com.example.roomdatabase.Db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity

class MyContact {

    @PrimaryKey(autoGenerate = true)
     var id:Int?=null

    constructor(name: String?, number: String?) {
        this.name = name
        this.number = number
    }

    constructor()

    var name:String?=null
    var number:String?=null

}