package com.mia.ysc.ui.english.exercise

import android.app.Dialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.Nullable
import androidx.appcompat.widget.Toolbar
import com.mia.ysc.R
import com.mia.ysc.databinding.ActivityMathExerciseBinding
import com.mia.ysc.ui.common.ViewFactory
import com.mia.ysc.ui.common.dialogs.progress.ProgressDialog
import com.mia.ysc.ui.common.toolbar.ToolbarView
import com.mia.ysc.ui.common.views.BaseObservableView

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class MathExerciseViewImpl(
    layoutInflater: LayoutInflater,
    @Nullable viewGroup: ViewGroup?,
    private val viewFactory: ViewFactory
) : BaseObservableView<ActivityMathExerciseBinding, MathExerciseView.Listener>(),
    MathExerciseView, ToolbarView.NavigationUpClickListener {

    private lateinit var mToolbarView: ToolbarView
    private var mToolbar: Toolbar
    private var operationType = 0;
    private var progressDialog: Dialog? = null

    init {
        setViewBinding(ActivityMathExerciseBinding.inflate(layoutInflater, viewGroup, false))
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

    override fun setDataForAddition() {
        operationType = 0;
        getViewBinding().tv1.setText("3")
        getViewBinding().tv2.setText("2")
        getViewBinding().tvOperation.setText("  +  ")
        val adapter = ArrayAdapter.createFromResource(
            getContext(),
            R.array.addition,
            android.R.layout.simple_spinner_item
        )
        getViewBinding().spinner.adapter = adapter
    }

    override fun setDataForSubtraction() {
        operationType = 1;
        getViewBinding().tv1.setText("6")
        getViewBinding().tv2.setText("4")
        getViewBinding().tvOperation.setText("  -  ")
        val adapter = ArrayAdapter.createFromResource(
            getContext(),
            R.array.subtraction,
            android.R.layout.simple_spinner_item
        )
        getViewBinding().spinner.adapter = adapter
    }

    override fun setDataForMultiplication() {
        operationType = 2;
        getViewBinding().tv1.setText("3")
        getViewBinding().tv2.setText("2")
        getViewBinding().tvOperation.setText("  X  ")
        val adapter = ArrayAdapter.createFromResource(
            getContext(),
            R.array.multiplication,
            android.R.layout.simple_spinner_item
        )
        getViewBinding().spinner.adapter = adapter
    }

    private fun onClickSubmit() {
        if (operationType == 0 && getViewBinding().spinner.selectedItemPosition != 2) {
            displayError()
            return
        } else if (operationType == 1 && getViewBinding().spinner.selectedItemPosition != 1) {
            displayError()
            return
        } else if (operationType == 2 && getViewBinding().spinner.selectedItemPosition != 3) {
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