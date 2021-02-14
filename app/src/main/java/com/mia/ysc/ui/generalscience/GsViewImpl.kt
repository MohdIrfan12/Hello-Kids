package com.mia.ysc.ui.questiondetail

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.mia.ysc.R
import com.mia.ysc.databinding.ActivityGsBinding
import com.mia.ysc.ui.common.ViewFactory
import com.mia.ysc.ui.common.toolbar.ToolbarView
import com.mia.ysc.ui.common.views.BaseObservableView
import com.mia.ysc.ui.generalscience.GsView
import com.mia.ysc.ui.generalscience.adapter.GsAdapter

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class GsViewImpl(
    layoutInflater: LayoutInflater,
    @Nullable viewGroup: ViewGroup?,
    private val viewFactory: ViewFactory,
    private val activity: AppCompatActivity
) : BaseObservableView<ActivityGsBinding, GsView.Listener>(),
    GsView, ToolbarView.NavigationUpClickListener, ToolbarView.MenuButtonClickListener,
    PopupMenu.OnMenuItemClickListener {

    private lateinit var mToolbarView: ToolbarView
    private lateinit var mToolbar: Toolbar

    init {
        setViewBinding(ActivityGsBinding.inflate(layoutInflater, viewGroup, false))
    }

    override fun initViewPagerAndTabs() {
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
        mToolbarView.setScreenTitle(getString(R.string.text_es))
        mToolbarView.setTitleColor(R.color.color_55BA6B)
        mToolbarView.enableNavigatioAndObserve(this)
        mToolbarView.enableMenuAndObserve(this)
    }


    private fun setAdapter() {
        val pagerAdapter = GsAdapter(activity)
        val pager = getViewBinding().viewPager;
        pager.adapter = pagerAdapter
    }

    override fun bindAlphabetArray(mAlphabetsArray: Array<String>) {
        TabLayoutMediator(getViewBinding().tabLayout, getViewBinding().viewPager)
        { tab, position ->
            tab.text = mAlphabetsArray[position]
        }.attach()
    }

    override fun onNavigationUpClicked() {
        for (listener in getListeners()) {
            listener.onNavigationUpClicked()
        }
    }

    override fun registerLister(listener: GsView.Listener) {
        super.registerLister(listener)
        getViewBinding().viewPager.registerOnPageChangeCallback(mOnPageChangeCallback)
    }

    override fun unregisterListener(listener: GsView.Listener) {
        super.unregisterListener(listener)
        getViewBinding().viewPager.unregisterOnPageChangeCallback(mOnPageChangeCallback)
    }

    override fun onMenuClicked() {
        //Creating the instance of PopupMenu
        val popup = PopupMenu(getContext(), mToolbarView.getViewBinding().ivViewMenu)
        //Inflating the Popup using xml file
        popup.getMenuInflater().inflate(R.menu.exercise_menu, popup.getMenu())
        //registering popup with OnMenuItemClickListener
        popup.setOnMenuItemClickListener(this)
        popup.show()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.exercise_one -> openExerciseOne()
        }
        return true
    }

    private fun openExerciseOne() {
        for (listener in getListeners()) {
            listener.onExcerciseClick()
        }
    }
}