package com.muhammadfurqan.bangkitfclass

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.muhammadfurqan.bangkitfclass.list.ListActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnToList: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnToList = findViewById(R.id.btn_to_list)
        btnToList.setOnClickListener { navigateToList() }
    }

    private fun navigateToList() {
        startActivity(
            Intent(this, ListActivity::class.java)
        )
    }
}