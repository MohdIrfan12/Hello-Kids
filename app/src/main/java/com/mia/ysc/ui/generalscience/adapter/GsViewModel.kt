package com.mia.ysc.ui.questionlist


import androidx.lifecycle.ViewModel
import com.mia.ysc.ui.generalscience.adapter.GsViewModelObserver

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class GsViewModel() : ViewModel() {

    private var mObserver: GsViewModelObserver? = null

    fun attachObserver(observer: GsViewModelObserver?, position: Int) {
        this.mObserver = observer;
        when (position) {
            0 -> mObserver?.setDataForPlants()
            1 -> mObserver?.setDataForAnimals()
            2 -> mObserver?.setDataForHumanBody()
            3 -> mObserver?.setDataForEnvirnment()
        }
    }

    fun removeObserver() {
        this.mObserver = null;
    }
}