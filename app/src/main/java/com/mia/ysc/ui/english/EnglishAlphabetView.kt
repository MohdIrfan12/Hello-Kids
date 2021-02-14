package com.mia.ysc.ui.english

import com.mia.ysc.databinding.ActivityEnglishBinding
import com.mia.ysc.ui.common.views.ObservableView

/**
 * Created by Mohd Irfan on 11/2/21.
 */
interface EnglishAlphabetView :
    ObservableView<ActivityEnglishBinding, EnglishAlphabetView.Listener> {

    interface Listener {
        fun onPageSelected(position: Int)
        fun onNavigationUpClicked()
        fun navigateToExerciseScreen()
        fun navigateToPrizeScreen()
    }

    fun initViewPagerAndTabs()
    fun bindAlphabetArray(mAlphabetsArray: Array<String>)
}