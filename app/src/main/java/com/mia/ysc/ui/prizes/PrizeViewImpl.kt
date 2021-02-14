package com.mia.ysc.ui.prizes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.appcompat.widget.Toolbar
import com.mia.ysc.R
import com.mia.ysc.databinding.ActivityPrizesBinding
import com.mia.ysc.ui.common.ViewFactory
import com.mia.ysc.ui.common.toolbar.ToolbarView
import com.mia.ysc.ui.common.views.BaseObservableView

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class PrizeViewImpl(
    layoutInflater: LayoutInflater,
    @Nullable viewGroup: ViewGroup?,
    private val viewFactory: ViewFactory
) : BaseObservableView<ActivityPrizesBinding, PrizeView.Listener>(),
    PrizeView, ToolbarView.NavigationUpClickListener {

    private lateinit var mToolbarView: ToolbarView
    private var mToolbar: Toolbar

    init {
        setViewBinding(ActivityPrizesBinding.inflate(layoutInflater, viewGroup, false))
        mToolbar = getViewBinding().root.findViewById(R.id.toolbar)
        initToolbarAndObserveEvents(viewFactory)
        mToolbar.addView(mToolbarView.getViewBinding().root)
    }

    private fun initToolbarAndObserveEvents(viewFactory: ViewFactory) {
        mToolbarView = viewFactory.getToolbarView(mToolbar)
        mToolbarView.setScreenTitle(getString(R.string.text_prize))
        mToolbarView.enableNavigatioAndObserve(this)
    }

    override fun onNavigationUpClicked() {
        for (listener in getListeners()) {
            listener.onNavigationUpClicked()
        }
    }
}