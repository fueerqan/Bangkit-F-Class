package com.muhammadfurqan.bangkitfclass.network

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.muhammadfurqan.bangkitfclass.R
import com.muhammadfurqan.bangkitfclass.network.data.JikanTopEntity
import com.muhammadfurqan.bangkitfclass.network.data.network.JikanAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkActivity : AppCompatActivity() {

    private lateinit var jikanApi: JikanAPI

    private lateinit var tvAnimeList: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        tvAnimeList = findViewById(R.id.tv_anime_list)
        progressBar = findViewById(R.id.loading_bar)

        createRetrofitService()
        runGetAnimeList()
    }

    private fun createRetrofitService() {
        val retrofit = Retrofit.Builder()
            .baseUrl(NetworkConst.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(createLoggingInterceptor())
            .build()

        jikanApi = retrofit.create(JikanAPI::class.java)
    }

    private fun createLoggingInterceptor(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    private fun runGetAnimeList() {
        progressBar.visibility = View.VISIBLE

        val call = jikanApi.getGenreList(
            NetworkConst.TYPE_ANIME,
            1,
            1
        )
        call.enqueue(object : Callback<JikanTopEntity> {
            override fun onFailure(call: Call<JikanTopEntity>, t: Throwable) {
                progressBar.visibility = View.GONE

                Toast.makeText(this@NetworkActivity, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<JikanTopEntity>,
                response: Response<JikanTopEntity>
            ) {
                progressBar.visibility = View.GONE

                Log.d("OkHttp", response.body()?.toString() ?: "")

                response.body()?.let { jikan ->
                    jikan.itemCount?.let { itemCount ->
                        if (itemCount > 0) {
                            val stringBuilder = StringBuilder()
                            for ((index, anime) in jikan.animeList.withIndex()) {
                                if (index > 5) break

                                stringBuilder.append(
                                    """
                                   ${anime.title}
                                    Episodes : ${anime.episodes}
                                    Airing : ${anime.airingStart}
                                    
                                """.trimIndent()
                                )
                            }
                            tvAnimeList.text = stringBuilder
                        }
                    }
                }
            }

        })
    }
}