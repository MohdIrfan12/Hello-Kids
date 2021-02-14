package com.mia.ysc.ui.questiondetail

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.mia.ysc.R
import com.mia.ysc.databinding.ActivityEnglishBinding
import com.mia.ysc.ui.common.ViewFactory
import com.mia.ysc.ui.common.toolbar.ToolbarView
import com.mia.ysc.ui.common.views.BaseObservableView
import com.mia.ysc.ui.english.EnglishAlphabetView
import com.mia.ysc.ui.english.alphabets.EnglishAlphabetAdapter

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class EnglishAlphabetViewImpl(
    layoutInflater: LayoutInflater,
    @Nullable viewGroup: ViewGroup?,
    private val viewFactory: ViewFactory,
    private val activity: AppCompatActivity
) : BaseObservableView<ActivityEnglishBinding, EnglishAlphabetView.Listener>(),
    EnglishAlphabetView, ToolbarView.NavigationUpClickListener,
    ToolbarView.MenuButtonClickListener, PopupMenu.OnMenuItemClickListener {

    private lateinit var mToolbarView: ToolbarView
    private val mToolbar: Toolbar

    init {
        setViewBinding(ActivityEnglishBinding.inflate(layoutInflater, viewGroup, false))
        mToolbar = getViewBinding().root.findViewById(R.id.toolbar)
    }

    override fun initViewPagerAndTabs() {
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
        getViewBinding().pb.visibility = View.GONE
        getViewBinding().tabLayout.visibility = View.VISIBLE
        mToolbarView = viewFactory.getToolbarView(mToolbar)
        mToolbarView.setScreenTitle(getString(R.string.text_english))
        mToolbarView.setTitleColor(R.color.colorAccent)
        mToolbarView.enableNavigatioAndObserve(this)
        mToolbarView.enableMenuAndObserve(this)
    }


    private fun setAdapter() {
        val pagerAdapter = EnglishAlphabetAdapter(activity)
        val pager = getViewBinding().viewPager;
        pager.adapter = pagerAdapter
    }

    override fun bindAlphabetArray(mAlphabetsArray: Array<String>) {
        TabLayoutMediator(getViewBinding().tabLayout, getViewBinding().viewPager)
        { tab, position ->
            tab.text = mAlphabetsArray[position].split(" ")[0]
        }.attach()
    }

    override fun registerLister(listener: EnglishAlphabetView.Listener) {
        super.registerLister(listener)
        getViewBinding().viewPager.registerOnPageChangeCallback(mOnPageChangeCallback)
    }

    override fun unregisterListener(listener: EnglishAlphabetView.Listener) {
        super.unregisterListener(listener)
        getViewBinding().viewPager.unregisterOnPageChangeCallback(mOnPageChangeCallback)
    }

    override fun onNavigationUpClicked() {
        for (listener in getListeners()) {
            listener.onNavigationUpClicked()
        }
    }

    override fun onMenuClicked() {
        //Creating the instance of PopupMenu
        val popup = PopupMenu(getContext(), mToolbar.findViewById(R.id.ivViewMenu))
        //Inflating the Popup using xml file
        popup.getMenuInflater().inflate(R.menu.exercise_menu, popup.getMenu())
        //registering popup with OnMenuItemClickListener
        popup.setOnMenuItemClickListener(this)
        popup.show()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.exercise_one -> openExerciseOne()
            R.id.prize_items -> opePrizeScreen()
        }
        return true
     }

    private fun openExerciseOne() {
        for (listener in getListeners()) {
            listener.navigateToExerciseScreen()
        }
    }

    private fun opePrizeScreen() {
        for (listener in getListeners()) {
            listener.navigateToPrizeScreen()
        }
    }
}