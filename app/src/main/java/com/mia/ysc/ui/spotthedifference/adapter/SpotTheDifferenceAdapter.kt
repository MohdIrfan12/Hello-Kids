package com.mia.ysc.ui.spotthedifference.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Created by Mohd Irfan on 12/2/21.
 */
class SpotTheDifferenceAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    private val ITEM_COUNT = 3

    override fun getItemCount(): Int {
        return ITEM_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return SpotTheDifferenceFragment.newInstance(position)
    }
}