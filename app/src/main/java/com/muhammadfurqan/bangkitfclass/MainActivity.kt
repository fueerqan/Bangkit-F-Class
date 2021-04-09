package com.muhammadfurqan.bangkitfclass

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.muhammadfurqan.bangkitfclass.backgroundprocess.BackgroundProcessActivity
import com.muhammadfurqan.bangkitfclass.fragment.FragmentActivity
import com.muhammadfurqan.bangkitfclass.list.ListActivity
import com.muhammadfurqan.bangkitfclass.network.NetworkActivity
import com.muhammadfurqan.bangkitfclass.shared_preferences.SharedPreferencesActivity
import com.muhammadfurqan.bangkitfclass.sqlite.SQLiteActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnToList: AppCompatButton
    private lateinit var btnToFragment: AppCompatButton
    private lateinit var btnToBackground: AppCompatButton
    private lateinit var btnToNetwork: AppCompatButton
    private lateinit var btnToSharedPref: AppCompatButton
    private lateinit var btnToSqlite: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnToFragment = findViewById(R.id.btn_to_fragment)
        btnToFragment.setOnClickListener { navigateToFragment() }

        btnToList = findViewById(R.id.btn_to_list)
        btnToList.setOnClickListener { navigateToList() }

        btnToBackground = findViewById(R.id.btn_to_background)
        btnToBackground.setOnClickListener { navigateToBackground() }

        btnToNetwork = findViewById(R.id.btn_to_network)
        btnToNetwork.setOnClickListener { navigateToNetwork() }

        btnToSharedPref = findViewById(R.id.btn_to_shared_pref)
        btnToSharedPref.setOnClickListener { navigateToSharedPreferences() }

        btnToSqlite = findViewById(R.id.btn_to_sqlite)
        btnToSqlite.setOnClickListener { navigateToSQLite() }
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

    private fun navigateToNetwork() {
        startActivity(
            Intent(this, NetworkActivity::class.java)
        )
    }

    private fun navigateToSharedPreferences() {
        startActivity(
            Intent(this, SharedPreferencesActivity::class.java)
        )
    }

    private fun navigateToSQLite() {
        startActivity(
            Intent(this, SQLiteActivity::class.java)
        )
    }
}