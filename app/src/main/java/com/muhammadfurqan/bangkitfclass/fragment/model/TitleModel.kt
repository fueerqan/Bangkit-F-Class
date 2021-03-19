package com.muhammadfurqan.bangkitfclass.fragment.model

import com.muhammadfurqan.bangkitfclass.BaseModel
import com.muhammadfurqan.bangkitfclass.fragment.adapter.FragmentAdapter

/**
 * @author by furqan on 19/03/2021
 */
data class TitleModel(val title: String) : BaseModel() {
    override fun getViewType(): Int = FragmentAdapter.TITLE_TYPE
}