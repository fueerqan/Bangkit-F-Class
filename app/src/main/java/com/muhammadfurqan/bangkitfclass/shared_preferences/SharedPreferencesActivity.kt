package com.muhammadfurqan.bangkitfclass.shared_preferences

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.muhammadfurqan.bangkitfclass.R

class SharedPreferencesActivity : AppCompatActivity() {

    private lateinit var etEmail: AppCompatEditText
    private lateinit var etPassword: AppCompatEditText
    private lateinit var btnLogin: AppCompatButton

    private lateinit var sessionPrefUtils: SessionPrefUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        sessionPrefUtils = SessionPrefUtils(
            getSharedPreferences(SessionPrefUtils.PREF_NAME, Context.MODE_PRIVATE)
        )

        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener {
            onLogin()
        }
    }

    private fun onLogin() {
        // validate user input
        // validate user login information

        // when they success to logged in
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()

        sessionPrefUtils.saveData(SessionPrefUtils.KEY_EMAIL, email)
        sessionPrefUtils.saveData(SessionPrefUtils.KEY_PASSWORD, password)
        sessionPrefUtils.saveData(SessionPrefUtils.KEY_IS_LOGGED_IN, true)
        sessionPrefUtils.applyEditor()
    }
}