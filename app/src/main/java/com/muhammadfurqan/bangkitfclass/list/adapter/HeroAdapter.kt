package com.muhammadfurqan.bangkitfclass.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfurqan.bangkitfclass.list.model.NationalHero
import com.muhammadfurqan.bangkitfclass.list.viewholder.HeroViewHolder

/**
 * @author by furqan on 19/03/2021
 */
class HeroAdapter(
    private val dataList: List<NationalHero>,
    private val listener: HeroViewHolder.Listener
) : RecyclerView.Adapter<HeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder =
        HeroViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(HeroViewHolder.LAYOUT, parent, false),
            listener
        )

//        // Step 1 : Create Layout Inflater
//        val layoutInflater = LayoutInflater.from(parent.context)
//        // Step 2 : Inflate the view
//        val view = layoutInflater.inflate(HeroViewHolder.LAYOUT, parent, false)
//        // Step 3 : Create View Holder
//        val viewHolder = HeroViewHolder(view)
//        // Step 4 : Return View Holder
//        return viewHolder

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

}