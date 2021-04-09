package com.muhammadfurqan.bangkitfclass.sqlite

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.lifecycle.lifecycleScope
import com.muhammadfurqan.bangkitfclass.R
import com.muhammadfurqan.bangkitfclass.sqlite.db.BookDatabaseManager
import kotlinx.coroutines.launch

class SQLiteActivity : AppCompatActivity() {

    private lateinit var etBookName: AppCompatEditText
    private lateinit var btnAdd: AppCompatButton
    private lateinit var btnRead: AppCompatButton

    private val bookDb: BookDatabaseManager by lazy {
        BookDatabaseManager(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)

        etBookName = findViewById(R.id.et_book_name)
        btnAdd = findViewById(R.id.btn_add)
        btnRead = findViewById(R.id.btn_read)

        btnAdd.setOnClickListener {
            onAdd()
        }

        btnRead.setOnClickListener {
            onRead()
        }
    }

    private fun onAdd() {
        val bookName = etBookName.text.toString()
        if (bookName.isNotEmpty()) {
            lifecycleScope.launch {
                bookDb.saveData(bookName)
            }
            etBookName.setText("")
        } else {
            Toast.makeText(this, "Please fill in the book name", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onRead() {
        val bookList = bookDb.getData()
        val bookListString = bookList.joinToString(separator = "\n") {
            "Book ${it.id} is ${it.name}"
        }
        Toast.makeText(this, bookListString, Toast.LENGTH_SHORT).show()
    }

}