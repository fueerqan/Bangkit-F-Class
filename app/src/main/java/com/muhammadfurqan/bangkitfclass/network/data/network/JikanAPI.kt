package com.muhammadfurqan.bangkitfclass.network.data.network

import com.muhammadfurqan.bangkitfclass.network.NetworkConst.GET_GENRE_URL
import com.muhammadfurqan.bangkitfclass.network.data.JikanTopEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author by furqan on 31/03/2021
 */
interface JikanAPI {

    @GET(GET_GENRE_URL)
    fun getGenreList(
        @Path("type") type: String,
        @Path("genre_id") genreId: Int,
        @Path("page") page: Int
    ) : Call<JikanTopEntity>

}