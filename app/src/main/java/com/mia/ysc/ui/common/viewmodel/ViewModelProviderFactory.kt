package com.mia.ysc.ui.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.mia.ysc.common.dependencyInjection.ControllerCompositionRoot
import com.mia.ysc.ui.questionlist.*

/**
 * Created by Mohd Irfan on 31/12/20.
 */
class ViewModelProviderFactory(private val controllerCompositionRoot: ControllerCompositionRoot) :
    NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(HruViewModel::class.java)) {
            return HruViewModel() as T
        } else if (modelClass.isAssignableFrom(VideoPlayerViewModel::class.java)) {
            return VideoPlayerViewModel() as T
        } else if (modelClass.isAssignableFrom(EnglishAlphabetViewModel::class.java)) {
            return EnglishAlphabetViewModel() as T
        } else if (modelClass.isAssignableFrom(AlphabetViewModel::class.java)) {
            return AlphabetViewModel() as T
        } else if (modelClass.isAssignableFrom(MathViewModel::class.java)) {
            return MathViewModel() as T
        } else if (modelClass.isAssignableFrom(GsViewModel::class.java)) {
            return GsViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}