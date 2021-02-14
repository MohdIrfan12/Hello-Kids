package com.mia.ysc.ui.questionlist


import androidx.lifecycle.ViewModel
import com.mia.ysc.ui.hru.HruViewModelObserver

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class HruViewModel() : ViewModel() {

    private var mObserver: HruViewModelObserver? = null

    fun attachObserver(observer: HruViewModelObserver?) {
        this.mObserver = observer;
    }

    fun removeObserver() {
        this.mObserver = null;
    }

    fun executeHappyClickEvent() {
        mObserver?.openHomeScreen()
    }

    fun executeSadClickEvent() {
        mObserver?.openVideoPlayerScreen()
    }
}