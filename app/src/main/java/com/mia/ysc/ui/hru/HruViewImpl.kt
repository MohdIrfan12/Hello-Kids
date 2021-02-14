package com.mia.ysc.ui.questiondetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.Nullable
import com.mia.ysc.databinding.ActivityHruBinding
import com.mia.ysc.ui.hru.HruView
import com.mia.ysc.ui.common.views.BaseObservableView

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class HruViewImpl(
    layoutInflater: LayoutInflater,
    @Nullable viewGroup: ViewGroup?
) : BaseObservableView<ActivityHruBinding, HruView.Listener>(), HruView {

    init {
        setViewBinding(ActivityHruBinding.inflate(layoutInflater, viewGroup, false))
        getViewBinding().ivHappy.setOnClickListener { onClickHappy() }
        getViewBinding().ivSad.setOnClickListener { onClickSad() }
    }

    private fun onClickHappy() {
        for (listener in getListeners()) {
            listener.onClickHappy()
        }
    }

    private fun onClickSad() {
        for (listener in getListeners()) {
            listener.onClickSad()
        }
    }
}