package com.muhammadfurqan.bangkitfclass.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfurqan.bangkitfclass.DummyData
import com.muhammadfurqan.bangkitfclass.databinding.ActivityListBinding
import com.muhammadfurqan.bangkitfclass.list.adapter.HeroAdapter
import com.muhammadfurqan.bangkitfclass.list.model.NationalHero
import com.muhammadfurqan.bangkitfclass.list.viewholder.HeroViewHolder

/**
 * @author by furqan on 19/03/2021
 */
class ListActivity : AppCompatActivity(), HeroViewHolder.Listener {

    private lateinit var binding: ActivityListBinding

    private lateinit var adapter: HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
    }

    override fun onClick(element: NationalHero) {
        startActivity(
            Intent(this, DetailActivity::class.java)
                .putExtra(EXTRA_HERO, element)
        )
    }

    private fun setupRecyclerView() {
        adapter = HeroAdapter(DummyData.HERO_DATA, this)

        binding.rvHeroList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvHeroList.adapter = adapter
    }

    companion object {
        const val EXTRA_HERO = "EXTRA_HERO"
    }
}