package com.mia.ysc.ui.questionlist


import androidx.lifecycle.ViewModel
import com.mia.ysc.ui.math.adapter.MathViewModelObserver
/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class MathViewModel() : ViewModel() {


    private var mObserver: MathViewModelObserver? = null

    fun attachObserver(observer: MathViewModelObserver?, position: Int) {
        this.mObserver = observer;
        when (position) {
            0 -> mObserver?.setDataForAddition()
            1 -> mObserver?.setDataForSubstraction()
            2 -> mObserver?.setDataForMultiplication()
        }
    }

    fun removeObserver() {
        this.mObserver = null;
    }
}