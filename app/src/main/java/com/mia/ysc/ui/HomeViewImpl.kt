package com.mia.ysc.ui.questiondetail

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.appcompat.widget.Toolbar
import com.mia.ysc.R
import com.mia.ysc.databinding.ActivityHomeBinding
import com.mia.ysc.ui.HomeView
import com.mia.ysc.ui.common.ViewFactory
import com.mia.ysc.ui.common.toolbar.ToolbarView
import com.mia.ysc.ui.common.views.BaseObservableView

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class HomeViewImpl(
    layoutInflater: LayoutInflater,
    @Nullable viewGroup: ViewGroup?,
    viewFactory: ViewFactory,
    private val activity: AppCompatActivity
) : BaseObservableView<ActivityHomeBinding, HomeView.Listener>(), HomeView,
    ToolbarView.MenuButtonClickListener, PopupMenu.OnMenuItemClickListener {

    private lateinit var mToolbarView: ToolbarView
    private val mToolbar: Toolbar

    init {
        setViewBinding(ActivityHomeBinding.inflate(layoutInflater, viewGroup, false))

        mToolbar = getViewBinding().root.findViewById(R.id.toolbar)
        initToolbarAndObserveEvents(viewFactory)
        mToolbar.addView(mToolbarView.getViewBinding().root)

        getViewBinding().cvEnglish.setOnClickListener { onClickEnglish() }
        getViewBinding().cvMath.setOnClickListener { onClickMath() }
        getViewBinding().cvEs.setOnClickListener { onClickES() }
        getViewBinding().cvSpotTheDiffence.setOnClickListener { onClickSpotTheDifference() }
    }

    private fun initToolbarAndObserveEvents(viewFactory: ViewFactory) {
        mToolbarView = viewFactory.getToolbarView(mToolbar)
        mToolbarView.setScreenTitle("")
        mToolbarView.setToolbarBackground(R.color.color_55BA6B)
        mToolbarView.enableMenuAndObserve(this)
    }


    private fun onClickES() {
        for (listener in getListeners()) {
            listener.onClickES()
        }
    }

    private fun onClickMath() {
        for (listener in getListeners()) {
            listener.onClickMath()
        }
    }

    private fun onClickEnglish() {
        for (listener in getListeners()) {
            listener.onClickEnglish()
        }
    }

    private fun onClickSpotTheDifference() {
        for (listener in getListeners()) {
            listener.onClickSpotTheDifference()
        }
    }

    override fun onMenuClicked() {
        //Creating the instance of PopupMenu
        val popup = PopupMenu(activity, mToolbar.findViewById(R.id.ivViewMenu))
        //Inflating the Popup using xml file
        popup.getMenuInflater().inflate(R.menu.home_menu, popup.getMenu())
        //registering popup with OnMenuItemClickListener
        popup.setOnMenuItemClickListener(this)
        popup.show()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
//            R.id.menuAdddress -> openAddressScreen()
            R.id.menuWatchVideo -> openVideoPlayerScreen()
            R.id.prize_items -> opePrizeScreen()
        }
        return true
    }

    private fun opePrizeScreen() {
        for (listener in getListeners()) {
            listener.onClickPrize()
        }
    }

    private fun openVideoPlayerScreen() {
        for (listener in getListeners()) {
            listener.onClickWatchVideo()
        }
    }

    private fun openAddressScreen() {
        for (listener in getListeners()) {
            listener.onClickAddress()
        }
    }
}