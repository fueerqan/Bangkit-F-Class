package com.muhammadfurqan.bangkitfclass.sqlite

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammadfurqan.bangkitfclass.sqlite.db.BookDatabaseManager
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {

    private lateinit var bookDb: BookDatabaseManager

    fun initDB(context: Context) = viewModelScope.launch {
        bookDb = BookDatabaseManager(context)
    }

    private val _books = MutableLiveData<List<BookModel>>()
    val books: LiveData<List<BookModel>> get() = _books

    fun getAllBooks() = viewModelScope.launch { _books.value = bookDb.getData() }

    fun addBook(bookName: String) = viewModelScope.launch {
        bookDb.saveData(bookName)
        getAllBooks()
    }

    fun updateBook(bookModel: BookModel) = viewModelScope.launch {
        bookDb.updateBooks(bookModel)
        getAllBooks()
    }

    fun deleteBook(bookId: String) = viewModelScope.launch {
        bookDb.deleteBook(bookId)
        getAllBooks()
    }
}