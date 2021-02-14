package com.mia.ysc.ui.common.controllers

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.mia.ysc.ui.common.fragmentframehelper.FragmentFrameWrapper
import com.mia.ysc.common.CommonApplication
import com.mia.ysc.common.dependencyInjection.ActivityCompositionRoot
import com.mia.ysc.common.dependencyInjection.ControllerCompositionRoot
import io.github.inflationx.viewpump.ViewPumpContextWrapper

abstract class BaseActivity : AppCompatActivity(), FragmentFrameWrapper {

    private val mActivityCompositionRoot by lazy {
        ActivityCompositionRoot(this, (application as CommonApplication).getCompositionRoot())
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

    override fun attachBaseContext(newBase: Context?) {
        var context = newBase?.let { ViewPumpContextWrapper.wrap(it) }
        super.attachBaseContext(context)
    }
}