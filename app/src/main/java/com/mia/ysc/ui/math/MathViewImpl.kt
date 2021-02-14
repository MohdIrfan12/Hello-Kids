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
import com.mia.ysc.databinding.ActivityMathBinding
import com.mia.ysc.ui.common.ViewFactory
import com.mia.ysc.ui.common.toolbar.ToolbarView
import com.mia.ysc.ui.common.views.BaseObservableView
import com.mia.ysc.ui.math.MathView
import com.mia.ysc.ui.math.adapter.MathAdapter

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class MathViewImpl(
    layoutInflater: LayoutInflater,
    @Nullable viewGroup: ViewGroup?,
    private val viewFactory: ViewFactory,
    private val activity: AppCompatActivity
) : BaseObservableView<ActivityMathBinding, MathView.Listener>(),
    MathView, ToolbarView.NavigationUpClickListener, ToolbarView.MenuButtonClickListener,
    PopupMenu.OnMenuItemClickListener {

    private lateinit var mToolbarView: ToolbarView
    private val mToolbar: Toolbar

    init {
        setViewBinding(ActivityMathBinding.inflate(layoutInflater, viewGroup, false))
        mToolbar = getViewBinding().root.findViewById(R.id.toolbar)
    }

    private val mOnPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (listener in getListeners()) {
                listener.onPageSelected(position)
            }
        }
    }

    override fun initViewPagerAndTabs() {
        initToolbarAndObserveEvents(viewFactory)
        mToolbar.addView(mToolbarView.getViewBinding().root)
        setAdapter()
    }

    private fun initToolbarAndObserveEvents(viewFactory: ViewFactory) {
        mToolbarView = viewFactory.getToolbarView(mToolbar)
        mToolbarView.setScreenTitle(getString(R.string.text_math))
        mToolbarView.setTitleColor(R.color.color_FF0000)
        mToolbarView.enableNavigatioAndObserve(this)
        mToolbarView.enableMenuAndObserve(this)
    }


    private fun setAdapter() {
        val pagerAdapter = MathAdapter(activity)
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

    override fun registerLister(listener: MathView.Listener) {
        super.registerLister(listener)
        getViewBinding().viewPager.registerOnPageChangeCallback(mOnPageChangeCallback)
    }

    override fun unregisterListener(listener: MathView.Listener) {
        super.unregisterListener(listener)
        getViewBinding().viewPager.unregisterOnPageChangeCallback(mOnPageChangeCallback)
    }

    override fun onMenuClicked() {
        val popup = PopupMenu(getContext(), mToolbarView.getViewBinding().ivViewMenu)
        popup.getMenuInflater().inflate(R.menu.exercise_menu2, popup.getMenu())
        popup.setOnMenuItemClickListener(this)
        popup.show()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.exercise_one -> onClickExerciseOne()
            R.id.exercise_two -> onClickExerciseTwo()
            R.id.exercise_three -> onClickExerciseThree()
        }
        return true
    }

    private fun onClickExerciseOne() {
        for (listener in getListeners()) {
            listener.onClickExerciseOne()
        }
    }

    private fun onClickExerciseTwo() {
        for (listener in getListeners()) {
            listener.onClickExerciseTwo()
        }
    }

    private fun onClickExerciseThree() {
        for (listener in getListeners()) {
            listener.onClickExerciseThree()
        }
    }
}