package com.muhammadfurqan.bangkitfclass.network.data

import com.google.gson.annotations.SerializedName

/**
 * @author by furqan on 31/03/2021
 */
data class JikanTopEntity(
    @field:SerializedName("request_hash")
    val requestHash: String?,
    @field:SerializedName("request_cached")
    val requestCache: Boolean?,
    @field:SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int?,
    @field:SerializedName("mal_url")
    val malUrl: MalUrlEntity?,
    @field:SerializedName("item_count")
    val itemCount: Int?,
    @field:SerializedName("anime")
    val animeList: List<AnimeEntity>,
)

data class MalUrlEntity(
    @field:SerializedName("mal_id")
    val malId: Int?,
    @field:SerializedName("type")
    val type: String?,
    @field:SerializedName("name")
    val name: String?,
    @field:SerializedName("url")
    val url: String?
)

data class AnimeEntity(
    @field:SerializedName("mal_id")
    val malId: Int?,
    @field:SerializedName("url")
    val url: String?,
    @field:SerializedName("title")
    val title: String?,
    @field:SerializedName("image_url")
    val imageUrl: String?,
    @field:SerializedName("synopsis")
    val synopsis: String?,
    @field:SerializedName("type")
    val type: String?,
    @field:SerializedName("airing_start")
    val airingStart: String?,
    @field:SerializedName("episodes")
    val episodes: Int?,
    @field:SerializedName("members")
    val members: Int?
)