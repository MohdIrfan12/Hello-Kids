package com.mia.ysc.ui.english.exercise

import android.app.Dialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.appcompat.widget.Toolbar
import com.mia.ysc.R
import com.mia.ysc.databinding.ActivityGsExerciseBinding
import com.mia.ysc.ui.common.ViewFactory
import com.mia.ysc.ui.common.dialogs.progress.ProgressDialog
import com.mia.ysc.ui.common.toolbar.ToolbarView
import com.mia.ysc.ui.common.views.BaseObservableView

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class GsExerciseViewImpl(
    layoutInflater: LayoutInflater,
    @Nullable viewGroup: ViewGroup?,
    private val viewFactory: ViewFactory
) : BaseObservableView<ActivityGsExerciseBinding, GsExerciseView.Listener>(),
    GsExerciseView, ToolbarView.NavigationUpClickListener {

    private lateinit var mToolbarView: ToolbarView
    private var mToolbar: Toolbar
    private var progressDialog: Dialog? = null

    init {
        setViewBinding(ActivityGsExerciseBinding.inflate(layoutInflater, viewGroup, false))
        mToolbar = getViewBinding().root.findViewById(R.id.toolbar)
        initToolbarAndObserveEvents(viewFactory)
        mToolbar.addView(mToolbarView.getViewBinding().root)
        getViewBinding().buttonSubmit.setOnClickListener { onClickSubmit() }
    }

    private fun initToolbarAndObserveEvents(viewFactory: ViewFactory) {
        mToolbarView = viewFactory.getToolbarView(mToolbar)
        mToolbarView.setScreenTitle(getString(R.string.text_exercise))
        mToolbarView.enableNavigatioAndObserve(this)
    }

    override fun onNavigationUpClicked() {
        for (listener in getListeners()) {
            listener.onNavigationUpClicked()
        }
    }

    private fun onClickSubmit() {
        if (!getViewBinding().rb11.isChecked) {
            displayError()
            return
        } else if (!getViewBinding().rb21.isChecked) {
            displayError()
            return
        } else if (!getViewBinding().rb43.isChecked) {
            displayError()
            return
        } else {
            for (listener in getListeners()) {
                listener.onClickSubmit()
            }
        }
    }

    private fun displayError() {
        for (listener in getListeners()) {
            listener.displayError()
        }
    }

    override fun showProgressBar() {
        hideProgressBar()
        progressDialog = ProgressDialog().show(getContext())
    }

    override fun hideProgressBar() {
        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog?.dismiss()
            progressDialog = null
        }
    }
}