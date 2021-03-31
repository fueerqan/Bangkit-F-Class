package com.muhammadfurqan.bangkitfclass.network

/**
 * @author by furqan on 31/03/2021
 */
object NetworkConst {
    const val BASE_URL = "https://api.jikan.moe/v3/"

    const val PATH_GENRE = "genre"

    const val TYPE_ANIME = "anime"
    const val TYPE_MANGA = "manga"
    const val TYPE_PEOPLE = "people"
    const val TYPE_CHARACTERS = "characters"

    const val GET_GENRE_URL = "$PATH_GENRE/{type}/{genre_id}/{page}"
}