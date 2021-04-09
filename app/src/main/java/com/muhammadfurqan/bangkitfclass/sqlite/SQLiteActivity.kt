package com.muhammadfurqan.bangkitfclass.sqlite

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfurqan.bangkitfclass.R

/**
 *
 * Contact : 081375496583
 *
 * Step :
 * 1. Fork our Repository (https://github.com/fueerqan/Bangkit-F-Class)
 *
 * CHALLENGE :
 * 1. Recycler View to show all of the data, previously we only show them in toast
 * 2. Add Function to edit the books data for each item in your Recycler View Items
 * 3. Add Function to delete the books data for each item in your Recycler View Items
 * 4. Notify Data Changes for you Recycler View
 *
 * Reward : Rp20.000 Go-Pay / OVO
 * Limit : No Limit Person
 * Dateline : 23.00
 *
 * Submit to https://forms.gle/CytSQSyQDJeivpkd7
 *
 */

class SQLiteActivity : AppCompatActivity() {

    private lateinit var etBookName: AppCompatEditText
    private lateinit var btnAdd: AppCompatButton
    private lateinit var rvBook: RecyclerView
    private val bookVm: BookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)
        bookVm.initDB(this)
        bookVm.getAllBooks()
        etBookName = findViewById(R.id.et_book_name)
        btnAdd = findViewById(R.id.btn_add)
        rvBook = findViewById(R.id.rv_book_list)

        bookVm.books.observe(this, { populateBooks(it) })
        btnAdd.setOnClickListener {
            onAdd()
            hideKeyboard(it)
        }
    }

    private fun onAdd() {
        val bookName = etBookName.text.toString()
        if (bookName.isNotEmpty()) {
            bookVm.addBook(bookName)
            etBookName.setText("")
        } else {
            Toast.makeText(this, "Please fill in the book name", Toast.LENGTH_SHORT).show()
        }
    }

    private fun populateBooks(bookList: List<BookModel>) {
        rvBook.apply {
            itemAnimator = DefaultItemAnimator()
            adapter = BookAdapter(bookList, bookVm)
        }
    }

    private fun Activity.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.applicationWindowToken, 0)
    }

}