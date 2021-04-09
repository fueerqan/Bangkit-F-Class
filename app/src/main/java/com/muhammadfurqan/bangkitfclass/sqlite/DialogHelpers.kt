package com.muhammadfurqan.bangkitfclass.sqlite

import android.app.Activity
import android.app.AlertDialog
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import com.muhammadfurqan.bangkitfclass.R

object DialogHelpers {

    enum class EditBook { UPDATE, DELETE }

    fun Activity.showEditDialog(
        bookModel: BookModel, onAction: (edit: EditBook, book: BookModel) -> Unit
    ) {
        val view = layoutInflater.inflate(R.layout.dialog_edit_book, null)
        val dialog = AlertDialog.Builder(this).setView(view).create()
        dialog.show()
        val edtBook = view.findViewById<EditText>(R.id.edt_book_name)
        val tilBook = view.findViewById<TextInputLayout>(R.id.tilBook)
        val btnUpdate = view.findViewById<Button>(R.id.btnUpdate)
        val btnDelete = view.findViewById<Button>(R.id.btnDelete)

        edtBook.addTextChangedListener(getTextWatcher { tilBook.isErrorEnabled = false })
        edtBook.setText(bookModel.name)

        btnDelete.setOnClickListener {
            onAction(EditBook.DELETE, bookModel)
            dialog.dismiss()
        }
        btnUpdate.setOnClickListener {
            if (edtBook.text.toString().isNotBlank()) {
                bookModel.name = edtBook.text.toString()
                onAction(EditBook.UPDATE, bookModel)
                dialog.dismiss()
            } else tilBook.apply {
                error = "Book name shouldn't empty"
                isErrorEnabled = true
            }
        }
    }

    fun Activity.showAlertDialog(
        title: String, message: String, positive: String? = "Yes", negative: String? = "Cancel",
        onAction: (isPositive: Boolean) -> Unit
    ) {
        AlertDialog.Builder(this).apply {
            setTitle(title)
            setMessage(message)
            setPositiveButton(positive) { _, _ -> onAction(true) }
            setNegativeButton(negative) { _, _ -> onAction(false) }
            show()
        }
    }

    private fun getTextWatcher(onTextChanged: () -> Unit) = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) = onTextChanged()
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    }
}