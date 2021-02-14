package com.mia.ysc.ui.generalscience.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Created by Mohd Irfan on 12/2/21.
 */
class GsAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    private val ITEM_COUNT = 4

    override fun getItemCount(): Int {
        return ITEM_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return GsFragment.newInstance(position)
    }
}