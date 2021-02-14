package com.mia.ysc.ui.address

import com.mia.ysc.databinding.ActivityAddressBinding
import com.mia.ysc.ui.common.views.ObservableView

/**
 * Created by Mohd Irfan on 11/2/21.
 */
interface AddressView :
    ObservableView<ActivityAddressBinding, AddressView.Listener> {

    interface Listener {
        fun onNavigationUpClicked()
    }
}