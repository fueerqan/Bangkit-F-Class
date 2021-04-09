package com.muhammadfurqan.bangkitfclass.sqlite

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfurqan.bangkitfclass.R
import com.muhammadfurqan.bangkitfclass.sqlite.DialogHelpers.showAlertDialog
import com.muhammadfurqan.bangkitfclass.sqlite.DialogHelpers.showEditDialog

class BookAdapter(
    private val bookList: List<BookModel>,
    private val bookVm: BookViewModel
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = bookList[position]
        val tvBook = holder.itemView.findViewById<TextView>(R.id.tv_book_name)
        val contentBook = holder.itemView.findViewById<CardView>(R.id.content_book)
        tvBook.text = book.name
        contentBook.setOnClickListener {
            (holder.itemView.context as Activity).let {
                it.showEditDialog(book) { edit, book ->
                    when (edit) {
                        DialogHelpers.EditBook.UPDATE -> bookVm.updateBook(book)
                        DialogHelpers.EditBook.DELETE -> it.showAlertDialog(
                            "Delete Book",
                            "Want to delete ${book.name} from your collection?"
                        ) { isDelete -> if (isDelete) bookVm.deleteBook(book.id.toString()) }
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int = bookList.size
}