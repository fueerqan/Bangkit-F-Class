package com.muhammadfurqan.bangkitfclass.fragment.viewholder

import com.muhammadfurqan.bangkitfclass.BaseModel
import com.muhammadfurqan.bangkitfclass.BaseViewHolder
import com.muhammadfurqan.bangkitfclass.databinding.ItemHeroTitleBinding
import com.muhammadfurqan.bangkitfclass.fragment.model.TitleModel

/**
 * @author by furqan on 19/03/2021
 */
class TitleViewHolder(private val binding: ItemHeroTitleBinding) : BaseViewHolder(binding.root) {

    override fun bind(element: BaseModel) {
        val data = element as TitleModel

        binding.tvTitle.text = data.title
    }
}