package com.muhammadfurqan.bangkitfclass.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.muhammadfurqan.bangkitfclass.R
import com.muhammadfurqan.bangkitfclass.list.model.NationalHero

/**
 * @author by furqan on 19/03/2021
 */
class DetailActivity : AppCompatActivity() {

    private lateinit var tvHeroName: AppCompatTextView
    private lateinit var hero: NationalHero

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tvHeroName = findViewById(R.id.tv_detail_hero_name)

        hero = intent.getParcelableExtra(ListActivity.EXTRA_HERO)
            ?: NationalHero("", "", "")
        tvHeroName.text = hero.name
    }

}