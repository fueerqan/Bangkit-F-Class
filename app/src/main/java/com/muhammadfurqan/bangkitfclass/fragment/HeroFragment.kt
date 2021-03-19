package com.muhammadfurqan.bangkitfclass.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfurqan.bangkitfclass.DummyData
import com.muhammadfurqan.bangkitfclass.R
import com.muhammadfurqan.bangkitfclass.fragment.adapter.FragmentAdapter
import com.muhammadfurqan.bangkitfclass.list.model.NationalHero
import com.muhammadfurqan.bangkitfclass.list.viewholder.HeroViewHolder

/**
 * @author by furqan on 19/03/2021
 */
class HeroFragment : Fragment(), HeroViewHolder.Listener {

    lateinit var fragmentListener: FragmentListener

    private lateinit var rvHeroFragmentList: RecyclerView

    private lateinit var adapter: FragmentAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_hero, container, false)

//        // Step 1 : inflate your view
//        val view = inflater.inflate(R.layout.fragment_hero, container, false)
//        // Step 2 : Return View
//        return view

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvHeroFragmentList = view.findViewById(R.id.rv_hero_fragment_list)
        setupRecyclerView()
    }

    override fun onClick(element: NationalHero) {
        fragmentListener.onClick(element)
    }

    private fun setupRecyclerView() {
        adapter = FragmentAdapter(DummyData.HERO_DATA, this)

        rvHeroFragmentList.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        rvHeroFragmentList.adapter = adapter
    }

    interface FragmentListener {
        fun onClick(element: NationalHero)
    }

}