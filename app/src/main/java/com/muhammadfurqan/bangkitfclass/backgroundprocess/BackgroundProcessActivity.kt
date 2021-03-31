package com.muhammadfurqan.bangkitfclass.backgroundprocess

import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.muhammadfurqan.bangkitfclass.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BackgroundProcessActivity : AppCompatActivity() {

    private lateinit var tvBgTask: TextView
    private lateinit var btnBgTaskHandler: Button
    private lateinit var btnBgTaskCoroutine: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background_process)

        tvBgTask = findViewById(R.id.tv_background_process)
        btnBgTaskHandler = findViewById(R.id.btn_background_process_handler)
        btnBgTaskCoroutine = findViewById(R.id.btn_background_process_coroutine)

        btnBgTaskHandler.setOnClickListener {
            runBackgroundWithHandler()
        }
        btnBgTaskCoroutine.setOnClickListener {
            runBackgroundWithCoroutine()
        }
    }

    private fun runBackgroundWithHandler() {
        Handler().postDelayed({
            tvBgTask.text = "Congratulations, you completed your handler background task"
        }, DELAY_IN_MILIS)
    }

    private fun runBackgroundWithCoroutine() {
        lifecycleScope.launch(Dispatchers.IO) {
            delay(DELAY_IN_MILIS)
            withContext(Dispatchers.Main) {
                tvBgTask.text = "Congratulations, you completed your coroutine background task"
            }
        }
    }

    companion object {
        private const val DELAY_IN_MILIS = 5000L
    }

}