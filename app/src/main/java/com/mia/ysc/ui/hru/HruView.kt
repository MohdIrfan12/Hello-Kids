package com.mia.ysc.ui.hru

import com.mia.ysc.databinding.ActivityHruBinding
import com.mia.ysc.ui.common.views.ObservableView

/**
 * Created by Mohd Irfan on 11/2/21.
 */
interface HruView :ObservableView<ActivityHruBinding, HruView.Listener>{

    interface Listener{
        fun onClickHappy()
        fun onClickSad()
    }
}