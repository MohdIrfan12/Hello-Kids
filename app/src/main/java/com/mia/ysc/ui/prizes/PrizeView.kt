package com.mia.ysc.ui.prizes

import com.mia.ysc.databinding.ActivityPrizesBinding
import com.mia.ysc.ui.common.views.ObservableView

/**
 * Created by Mohd Irfan on 11/2/21.
 */
interface PrizeView :
    ObservableView<ActivityPrizesBinding, PrizeView.Listener> {

    interface Listener {
        fun onNavigationUpClicked()
    }
}