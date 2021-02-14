package com.mia.ysc.ui.spotthedifference

import com.mia.ysc.databinding.ActivityFindthedifferenceBinding
import com.mia.ysc.ui.common.views.ObservableView

/**
 * Created by Mohd Irfan on 11/2/21.
 */
interface SpotTheDifferenceView : ObservableView<ActivityFindthedifferenceBinding, SpotTheDifferenceView.Listener> {

    interface Listener {
        fun onPageSelected(position: Int)
        fun onNavigationUpClicked()
    }

    fun bindArray(mArray: Array<String>)
}