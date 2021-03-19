package com.muhammadfurqan.bangkitfclass.list.viewholder

import com.bumptech.glide.Glide
import com.muhammadfurqan.bangkitfclass.BaseModel
import com.muhammadfurqan.bangkitfclass.BaseViewHolder
import com.muhammadfurqan.bangkitfclass.databinding.ItemHeroBinding
import com.muhammadfurqan.bangkitfclass.list.model.NationalHero

/**
 * @author by furqan on 19/03/2021
 */
class HeroViewHolder(
    private val binding: ItemHeroBinding,
    private val listener: Listener
) : BaseViewHolder(binding.root) {

//    private var civHero: CircleImageView
//    private var tvHeroName: AppCompatTextView
//    private var tvHeroDescription: AppCompatTextView
//
//    init {
//        with(itemView) {
//            civHero = findViewById(R.id.civ_hero)
//            tvHeroName = findViewById(R.id.tv_hero_name)
//            tvHeroDescription = findViewById(R.id.tv_hero_description)
//        }
//    }

    override fun bind(element: BaseModel) {
        val data = element as NationalHero
        binding.tvHeroName.text = data.name
        binding.tvHeroDescription.text = data.description

        Glide.with(itemView.context)
            .load(data.imageUrl)
            .into(binding.civHero)

        itemView.setOnClickListener {
            listener.onClick(data)
        }
    }

    interface Listener {
        fun onClick(element: NationalHero)
    }

//    companion object {
//        val LAYOUT = R.layout.item_hero
//    }

}