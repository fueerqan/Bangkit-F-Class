package com.muhammadfurqan.bangkitfclass.list.model

import android.os.Parcelable
import com.muhammadfurqan.bangkitfclass.BaseModel
import com.muhammadfurqan.bangkitfclass.fragment.adapter.FragmentAdapter
import kotlinx.android.parcel.Parcelize

/**
 * @author by furqan on 19/03/2021
 */
@Parcelize
data class NationalHero(
    val name: String,
    val description: String,
    val imageUrl: String
) : BaseModel(), Parcelable {
    override fun getViewType(): Int = FragmentAdapter.MAIN_HERO_TYPE
}