package com.mia.ysc.ui.english.alphabets

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Created by Mohd Irfan on 12/2/21.
 */
class EnglishAlphabetAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 26
    }

    override fun createFragment(position: Int): Fragment {
        return EnglishAlphabetFragment.newInstance(position)
    }
}