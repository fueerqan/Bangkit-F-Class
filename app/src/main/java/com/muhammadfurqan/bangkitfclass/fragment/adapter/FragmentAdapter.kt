package com.muhammadfurqan.bangkitfclass.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfurqan.bangkitfclass.BaseModel
import com.muhammadfurqan.bangkitfclass.BaseViewHolder
import com.muhammadfurqan.bangkitfclass.databinding.ItemAnotherHeroBinding
import com.muhammadfurqan.bangkitfclass.databinding.ItemHeroBinding
import com.muhammadfurqan.bangkitfclass.databinding.ItemHeroTitleBinding
import com.muhammadfurqan.bangkitfclass.fragment.viewholder.ReverseHeroViewHolder
import com.muhammadfurqan.bangkitfclass.fragment.viewholder.TitleViewHolder
import com.muhammadfurqan.bangkitfclass.list.model.NationalHero
import com.muhammadfurqan.bangkitfclass.list.viewholder.HeroViewHolder

/**
 * @author by furqan on 19/03/2021
 */
class FragmentAdapter(
    private val dataList: List<BaseModel>,
    private val listener: HeroViewHolder.Listener
) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        when (viewType) {
            TITLE_TYPE -> TitleViewHolder(
                ItemHeroTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            REVERSE_HERO_TYPE -> ReverseHeroViewHolder(
                ItemAnotherHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> HeroViewHolder(
                ItemHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false),
                listener
            )
        }

//        // Step 1 : Create Layout Inflater
//        val layoutInflater = LayoutInflater.from(parent.context)
//        // Step 2 : Inflate the view
//        val view = layoutInflater.inflate(HeroViewHolder.LAYOUT, parent, false)
//        // Step 3 : Create View Holder
//        val viewHolder = HeroViewHolder(view)
//        // Step 4 : Return View Holder
//        return viewHolder

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemViewType(position: Int): Int =
        if (dataList[position] is NationalHero) {
            if ((position % 2) == 0) MAIN_HERO_TYPE else REVERSE_HERO_TYPE
        } else {
            dataList[position].getViewType()
        }

    companion object {
        const val TITLE_TYPE = 1
        const val MAIN_HERO_TYPE = 2
        const val REVERSE_HERO_TYPE = 3
    }

}