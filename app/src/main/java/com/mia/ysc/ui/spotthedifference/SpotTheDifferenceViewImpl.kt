package com.mia.ysc.ui.spotthedifference

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.mia.ysc.R
import com.mia.ysc.databinding.ActivityFindthedifferenceBinding
import com.mia.ysc.ui.common.ViewFactory
import com.mia.ysc.ui.common.toolbar.ToolbarView
import com.mia.ysc.ui.common.views.BaseObservableView
import com.mia.ysc.ui.spotthedifference.adapter.SpotTheDifferenceAdapter

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class SpotTheDifferenceViewImpl(
    layoutInflater: LayoutInflater,
    @Nullable viewGroup: ViewGroup?,
    viewFactory: ViewFactory,
    private val activity: AppCompatActivity
) : BaseObservableView<ActivityFindthedifferenceBinding, SpotTheDifferenceView.Listener>(),
    SpotTheDifferenceView, ToolbarView.NavigationUpClickListener {

    private lateinit var mToolbarView: ToolbarView
    private val mToolbar: Toolbar

    init {
        setViewBinding(ActivityFindthedifferenceBinding.inflate(layoutInflater, viewGroup, false))
        mToolbar = getViewBinding().root.findViewById(R.id.toolbar)
        initToolbarAndObserveEvents(viewFactory)
        mToolbar.addView(mToolbarView.getViewBinding().root)
        setAdapter()
    }

    private val mOnPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (listener in getListeners()) {
                listener.onPageSelected(position)
            }
        }
    }

    private fun initToolbarAndObserveEvents(viewFactory: ViewFactory) {
        mToolbarView = viewFactory.getToolbarView(mToolbar)
        mToolbarView.setScreenTitle(getString(R.string.text_std))
        mToolbarView.setTitleColor(R.color.color_FF0000)
        mToolbarView.enableNavigatioAndObserve(this)
    }


    private fun setAdapter() {
        val pagerAdapter = SpotTheDifferenceAdapter(activity)
        val pager = getViewBinding().viewPager;
        pager.adapter = pagerAdapter
    }

    override fun bindArray(mArray: Array<String>) {
        TabLayoutMediator(getViewBinding().tabLayout, getViewBinding().viewPager)
        { tab, position ->
            tab.text = mArray[position]
        }.attach()
    }

    override fun onNavigationUpClicked() {
        for (listener in getListeners()) {
            listener.onNavigationUpClicked()
        }
    }

    override fun registerLister(listener: SpotTheDifferenceView.Listener) {
        super.registerLister(listener)
        getViewBinding().viewPager.registerOnPageChangeCallback(mOnPageChangeCallback)
    }

    override fun unregisterListener(listener: SpotTheDifferenceView.Listener) {
        super.unregisterListener(listener)
        getViewBinding().viewPager.unregisterOnPageChangeCallback(mOnPageChangeCallback)
    }
}