package com.muhammadfurqan.bangkitfclass

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.muhammadfurqan.bangkitfclass.backgroundprocess.BackgroundProcessActivity
import com.muhammadfurqan.bangkitfclass.fragment.FragmentActivity
import com.muhammadfurqan.bangkitfclass.list.ListActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnToList: AppCompatButton
    private lateinit var btnToFragment: AppCompatButton
    private lateinit var btnToBackground: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnToFragment = findViewById(R.id.btn_to_fragment)
        btnToFragment.setOnClickListener { navigateToFragment() }

        btnToList = findViewById(R.id.btn_to_list)
        btnToList.setOnClickListener { navigateToList() }

        btnToBackground = findViewById(R.id.btn_to_background)
        btnToBackground.setOnClickListener { navigateToBackground() }
    }

    private fun navigateToList() {
        startActivity(
            Intent(this, ListActivity::class.java)
        )
    }

    private fun navigateToFragment() {
        startActivity(
            Intent(this, FragmentActivity::class.java)
        )
    }

    private fun navigateToBackground() {
        startActivity(
            Intent(this, BackgroundProcessActivity::class.java)
        )
    }
}