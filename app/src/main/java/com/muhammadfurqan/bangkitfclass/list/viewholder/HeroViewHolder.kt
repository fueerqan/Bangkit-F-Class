package com.muhammadfurqan.bangkitfclass.list.viewholder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muhammadfurqan.bangkitfclass.R
import com.muhammadfurqan.bangkitfclass.list.model.NationalHero
import de.hdodenhof.circleimageview.CircleImageView

/**
 * @author by furqan on 19/03/2021
 */
class HeroViewHolder(
    view: View,
    private val listener: Listener
) : RecyclerView.ViewHolder(view) {

    private var civHero: CircleImageView
    private var tvHeroName: AppCompatTextView
    private var tvHeroDescription: AppCompatTextView

    init {
        with(itemView) {
            civHero = findViewById(R.id.civ_hero)
            tvHeroName = findViewById(R.id.tv_hero_name)
            tvHeroDescription = findViewById(R.id.tv_hero_description)
        }
    }

    fun bind(element: NationalHero) {
        tvHeroName.text = element.name
        tvHeroDescription.text = element.description

        Glide.with(itemView.context)
            .load(element.imageUrl)
            .into(civHero)

        itemView.setOnClickListener {
            listener.onClick(element)
        }
    }

    interface Listener {
        fun onClick(element: NationalHero)
    }

    companion object {
        val LAYOUT = R.layout.item_hero
    }

}