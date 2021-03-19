package com.muhammadfurqan.bangkitfclass.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.muhammadfurqan.bangkitfclass.R
import com.muhammadfurqan.bangkitfclass.list.model.NationalHero

/**
 * @author by furqan on 19/03/2021
 */
class DetailFragment : Fragment() {

    private lateinit var tvHeroName: AppCompatTextView
    private lateinit var tvHeroDesc: AppCompatTextView

    private lateinit var hero: NationalHero

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvHeroName = view.findViewById(R.id.tv_detail_fragment_name)
        tvHeroDesc = view.findViewById(R.id.tv_detail_fragment_description)

        hero = arguments?.getParcelable(FragmentActivity.ARG_HERO)
            ?: NationalHero("", "", "")
        tvHeroName.text = hero.name
        tvHeroDesc.text = hero.description
    }

}