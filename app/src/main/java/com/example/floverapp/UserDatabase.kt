package com.example.floverapp

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class UserDatabase(val context: Context, val factory: SQLiteDatabase.CursorFactory?):
    SQLiteOpenHelper(context, "Users", factory,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INTEGER PRIMARY KEY, login TEXT,email TEXT, pass TEXT)"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
       db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun addUser(user: User){
        val values = ContentValues()
        values.put("login",user.login)
        values.put("email",user.email)
        values.put("pass",user.pass)

        val db =this.writableDatabase
        db.insert("Users", null, values)

        db.close()
    }

    @SuppressLint("Recycle")
    fun getUser(login: String, pass: String): Boolean{
        val db =this.readableDatabase

        val result = db.rawQuery("SELECT *FROM Users WHERE login = '$login' AND pass ='$pass'",null)
        return result.moveToFirst()
    }
}