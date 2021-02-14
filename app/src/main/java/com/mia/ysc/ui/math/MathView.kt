package com.mia.ysc.ui.math

import com.mia.ysc.databinding.ActivityMathBinding
import com.mia.ysc.ui.common.views.ObservableView

/**
 * Created by Mohd Irfan on 11/2/21.
 */
interface MathView : ObservableView<ActivityMathBinding, MathView.Listener> {

    interface Listener {
        fun onPageSelected(position: Int)
        fun onNavigationUpClicked()
        fun onClickExerciseOne()
        fun onClickExerciseTwo()
        fun onClickExerciseThree()
    }

    fun initViewPagerAndTabs()
    fun bindAlphabetArray(mAlphabetsArray: Array<String>)
}