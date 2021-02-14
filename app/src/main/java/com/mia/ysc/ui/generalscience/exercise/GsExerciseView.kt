package com.mia.ysc.ui.english.exercise

import com.mia.ysc.databinding.ActivityGsExerciseBinding
import com.mia.ysc.ui.common.views.ObservableView

/**
 * Created by Mohd Irfan on 11/2/21.
 */
interface GsExerciseView :
    ObservableView<ActivityGsExerciseBinding, GsExerciseView.Listener> {

    interface Listener {
        fun onNavigationUpClicked()
        fun onClickSubmit()
        fun displayError()
    }

    fun showProgressBar()
    fun hideProgressBar()
}