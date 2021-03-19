package com.muhammadfurqan.bangkitfclass.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muhammadfurqan.bangkitfclass.databinding.ItemHeroBinding
import com.muhammadfurqan.bangkitfclass.list.model.NationalHero

/**
 * @author by furqan on 19/03/2021
 */
class HeroViewHolder(
    private val binding: ItemHeroBinding,
    private val listener: Listener
) : RecyclerView.ViewHolder(binding.root) {

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

    fun bind(element: NationalHero) {
        binding.tvHeroName.text = element.name
        binding.tvHeroDescription.text = element.description

        Glide.with(itemView.context)
            .load(element.imageUrl)
            .into(binding.civHero)

        itemView.setOnClickListener {
            listener.onClick(element)
        }
    }

    interface Listener {
        fun onClick(element: NationalHero)
    }

//    companion object {
//        val LAYOUT = R.layout.item_hero
//    }

}