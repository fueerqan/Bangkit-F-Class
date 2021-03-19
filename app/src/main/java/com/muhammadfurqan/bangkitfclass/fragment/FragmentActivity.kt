package com.muhammadfurqan.bangkitfclass.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.muhammadfurqan.bangkitfclass.R
import com.muhammadfurqan.bangkitfclass.list.model.NationalHero

/**
 * @author by furqan on 19/03/2021
 */
class FragmentActivity : AppCompatActivity(), HeroFragment.FragmentListener {

    private lateinit var heroFragment: HeroFragment
    private lateinit var detailFragment: DetailFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        setupHeroFragment()
    }

    override fun onClick(element: NationalHero) {
        setupDetailFragment(element)
    }

    private fun setupHeroFragment() {
        heroFragment = HeroFragment()
        heroFragment.fragmentListener = this

        supportFragmentManager.beginTransaction()
            .add(R.id.fl_fragment_container, heroFragment)
            .commit()
    }

    private fun setupDetailFragment(element: NationalHero) {
        detailFragment = DetailFragment().also {
            it.arguments = Bundle().apply {
                putParcelable(ARG_HERO, element)
            }
        }

//        // Step 1 : Create Bundle
//        val bundle = Bundle()
//        // Step 2 : Put all data to bundle
//        bundle.putParcelable(ARG_HERO, element)
//        // Step 3 : Set your bundle to fragment arguments
//        detailFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_fragment_container, detailFragment)
            .addToBackStack(null)
            .commit()
    }

    companion object {
        const val ARG_HERO = "ARG_HERO"
    }
}