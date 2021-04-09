package com.muhammadfurqan.bangkitfclass.sqlite.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * @author by furqan on 09/04/2021
 */
class BookDatabaseOpenHelper(context: Context) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val createBookTable = "CREATE TABLE $TABLE_BOOK ( " +
                "$KEY_ID INTEGER PRIMARY KEY, " +
                "$KEY_NAME TEXT )"
        db.execSQL(createBookTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_BOOK")
        onCreate(db)
    }

    companion object {
        private const val DB_NAME = "book-f.db"
        private const val DB_VERSION = 1

        const val TABLE_BOOK = "book"
        const val KEY_ID = "id"
        const val KEY_NAME = "name"
    }
}