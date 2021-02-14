package com.mia.ysc.ui

import com.mia.ysc.databinding.ActivityHomeBinding
import com.mia.ysc.ui.common.views.ObservableView

/**
 * Created by Mohd Irfan on 11/2/21.
 */
interface HomeView : ObservableView<ActivityHomeBinding, HomeView.Listener> {

    interface Listener {
        fun onClickEnglish()
        fun onClickMath()
        fun onClickES()
        fun onClickSpotTheDifference()
        fun onClickAddress()
        fun onClickWatchVideo()
        fun onClickPrize()
    }
}