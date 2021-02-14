package com.mia.ysc.common.dependencyInjection

import android.content.Context
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.mia.ysc.networking.EndpointFactory
import com.mia.ysc.questions.UsecaseFactory
import com.mia.ysc.common.eventbus.EventBus
import com.mia.ysc.common.permissions.FragmentPermissionsHelper
import com.mia.ysc.networking.StackoverflowApi
import com.mia.ysc.ui.common.ViewFactory
import com.mia.ysc.ui.common.controllers.BackPressDispatcher
import com.mia.ysc.ui.common.dialogs.DialogsManager
import com.mia.ysc.ui.common.screensnavigator.ScreenNavigatior
import com.mia.ysc.ui.common.toasthelper.ToastHelper
import com.mia.ysc.ui.common.fragmentframehelper.FragmentFrameHelper
import com.mia.ysc.ui.common.fragmentframehelper.FragmentFrameWrapper
import com.mia.ysc.ui.common.viewmodel.ViewModelProviderFactory
import com.mia.ysc.common.permissions.ActivityPermissionsHelper
import com.mia.ysc.ui.common.tts.TTSFactory

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class ControllerCompositionRoot(private val mActivityCompositionRoot: ActivityCompositionRoot) {

    private val mActivityPermissionsHelper by lazy {
        ActivityPermissionsHelper(getActivity())
    }

    private val mTTSFactory by lazy {
        TTSFactory(getActivity())
    }

    private var mFragmentPermissionsHelper: FragmentPermissionsHelper? = null

    fun getStackOverFlowApi(): StackoverflowApi {
        return mActivityCompositionRoot.getStackOverFlowApi()
    }

    private fun getContext(): Context {
        return mActivityCompositionRoot.getContext()
    }

    private fun getActivity(): FragmentActivity {
        return mActivityCompositionRoot.getActivity()
    }

    fun getEventBus(): EventBus {
        return mActivityCompositionRoot.getEventBus()
    }

    fun getActivityPermissionsHelper(): ActivityPermissionsHelper {
        return mActivityPermissionsHelper
    }

    private fun getFragmentManager(): FragmentManager {
        return getActivity().supportFragmentManager
    }

    private fun getLayoutInflator(): LayoutInflater {
        return LayoutInflater.from(getContext())
    }

    fun getViewFactory(): ViewFactory {
        return ViewFactory(getLayoutInflator())
    }

    fun getScreenNavigatior(): ScreenNavigatior {
        return ScreenNavigatior(getContext(), getFragmentFrameHelper())
    }

    internal fun getMessageDisplayer(): ToastHelper {
        return ToastHelper(getContext())
    }

    fun getBackPressDispatcher(): BackPressDispatcher {
        return getActivity() as BackPressDispatcher
    }

    fun getDialogsManager(): DialogsManager {
        return DialogsManager(getContext(), getFragmentManager())
    }

    private fun getFragmentFrameHelper(): FragmentFrameHelper {
        return FragmentFrameHelper(getActivity(), getFragmentFrameWrapper(), getFragmentManager())
    }

    private fun getFragmentFrameWrapper(): FragmentFrameWrapper {
        return getActivity() as FragmentFrameWrapper
    }

    fun getFragmentPermissionsHelper(mFragment: Fragment): FragmentPermissionsHelper {
        if (mFragmentPermissionsHelper == null) {
            mFragmentPermissionsHelper =
                FragmentPermissionsHelper(mFragment)
        }
        return mFragmentPermissionsHelper!!
    }

    fun getEndpointFactory(): EndpointFactory {
        return EndpointFactory(getStackOverFlowApi())
    }

    fun getUsecaseFactory(): UsecaseFactory {
        return UsecaseFactory(getEndpointFactory())
    }

    fun getViewModelProviderFactory(): ViewModelProviderFactory {
        return ViewModelProviderFactory(this)
    }

    fun getTTSFactory(): TTSFactory {
      return mTTSFactory
    }
}