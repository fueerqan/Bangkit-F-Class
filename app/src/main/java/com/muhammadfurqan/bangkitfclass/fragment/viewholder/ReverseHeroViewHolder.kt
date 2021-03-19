package com.muhammadfurqan.bangkitfclass.fragment.viewholder

import com.muhammadfurqan.bangkitfclass.BaseModel
import com.muhammadfurqan.bangkitfclass.BaseViewHolder
import com.muhammadfurqan.bangkitfclass.databinding.ItemAnotherHeroBinding
import com.muhammadfurqan.bangkitfclass.list.model.NationalHero

/**
 * @author by furqan on 19/03/2021
 */
class ReverseHeroViewHolder(private val binding: ItemAnotherHeroBinding) :
    BaseViewHolder(binding.root) {

    override fun bind(element: BaseModel) {
        val data = element as NationalHero

        binding.tvHeroDescription.text = data.description
        binding.tvHeroName.text = data.name
    }

}