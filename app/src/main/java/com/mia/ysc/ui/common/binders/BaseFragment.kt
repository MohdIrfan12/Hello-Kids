package com.mia.ysc.ui.common.controllers

import androidx.fragment.app.Fragment
import com.mia.ysc.common.CommonApplication
import com.mia.ysc.common.dependencyInjection.ActivityCompositionRoot
import com.mia.ysc.common.dependencyInjection.ControllerCompositionRoot
import com.mia.ysc.common.permissions.FragmentPermissionsHelper

/**
 * Created by Mohd Irfan
 * on 01/01/21.
 */
abstract class BaseFragment : Fragment() {

    private val mActivityCompositionRoot by lazy {
        ActivityCompositionRoot(
            requireActivity(),
            (requireActivity().application as CommonApplication).getCompositionRoot()
        )
    }

    private val mControllerCompositionRoot by lazy {
        ControllerCompositionRoot(getActivityCompositionRoot())
    }

    protected fun getActivityCompositionRoot(): ActivityCompositionRoot {
        return mActivityCompositionRoot
    }

    protected fun getControllerCompositionRoot(): ControllerCompositionRoot {
        return mControllerCompositionRoot
    }
}