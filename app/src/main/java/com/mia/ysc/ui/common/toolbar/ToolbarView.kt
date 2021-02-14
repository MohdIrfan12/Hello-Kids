package com.mia.ysc.ui.common.toolbar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat
import com.mia.ysc.databinding.LayoutToolbarBinding
import com.mia.ysc.ui.common.views.BaseView

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class ToolbarView :
    BaseView<LayoutToolbarBinding> {

    interface NavigationUpClickListener {
        fun onNavigationUpClicked()
    }

    interface MenuButtonClickListener {
        fun onMenuClicked()
    }

    constructor(inflater: LayoutInflater, @Nullable parent: ViewGroup?) {
        setViewBinding(LayoutToolbarBinding.inflate(inflater, parent, false))
    }

    fun setScreenTitle(titleText: String) {
        getViewBinding().tvToolbarTitle.setText(titleText)
    }

    fun setTitleColor(colorId: Int) {
        getViewBinding().tvToolbarTitle.setTextColor(ContextCompat.getColor(getContext(), colorId))
    }

    fun setToolbarBackground(colorId: Int) {
        getViewBinding().rlToolbar.setBackgroundColor(ContextCompat.getColor(getContext(), colorId))
    }

    fun enableNavigatioAndObserve(listener: NavigationUpClickListener) {
        getViewBinding().btnBack.visibility = View.VISIBLE
        getViewBinding().btnBack.setOnClickListener {
            listener.onNavigationUpClicked()
        }
    }

    fun enableMenuAndObserve(listener: MenuButtonClickListener) {
        getViewBinding().ivViewMenu.visibility = View.VISIBLE
        getViewBinding().ivViewMenu.setOnClickListener {
            listener.onMenuClicked()
        }
    }
}