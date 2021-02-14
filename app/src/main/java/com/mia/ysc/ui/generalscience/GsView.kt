package com.mia.ysc.ui.generalscience

import com.mia.ysc.databinding.ActivityGsBinding
import com.mia.ysc.ui.common.views.ObservableView

/**
 * Created by Mohd Irfan on 11/2/21.
 */
interface GsView : ObservableView<ActivityGsBinding, GsView.Listener> {

    interface Listener {
        fun onPageSelected(position: Int)
        fun onNavigationUpClicked()
        fun onExcerciseClick()
    }

    fun initViewPagerAndTabs()
    fun bindAlphabetArray(mAlphabetsArray: Array<String>)
}