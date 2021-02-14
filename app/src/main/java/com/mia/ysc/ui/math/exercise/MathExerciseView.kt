package com.mia.ysc.ui.english.exercise

import com.mia.ysc.databinding.ActivityMathExerciseBinding
import com.mia.ysc.ui.common.views.ObservableView

/**
 * Created by Mohd Irfan on 11/2/21.
 */
interface MathExerciseView :
    ObservableView<ActivityMathExerciseBinding, MathExerciseView.Listener> {

    interface Listener {
        fun onNavigationUpClicked()
        fun onClickSubmit()
        fun displayError()
    }

    fun setDataForAddition()
    fun setDataForSubtraction()
    fun setDataForMultiplication()
    fun showProgressBar()
    fun hideProgressBar()
}