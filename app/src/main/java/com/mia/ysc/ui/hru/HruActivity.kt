package com.mia.ysc.ui.hru

import android.os.Bundle
import android.widget.FrameLayout
import androidx.lifecycle.ViewModelProvider
import com.mia.ysc.ui.common.controllers.BaseActivity
import com.mia.ysc.ui.questionlist.HruViewModel
import com.mia.ysc.ui.common.tts.TTSFactory

class HruActivity : BaseActivity(), HruView.Listener, HruViewModelObserver,TTSFactory.Listener {

    private lateinit var mHruView: HruView
    private lateinit var mHruViewModel: HruViewModel
    private lateinit var mTTSFactory: TTSFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mHruView = getControllerCompositionRoot().getViewFactory().getHruView(null)
        mHruViewModel = ViewModelProvider(
            this, getControllerCompositionRoot()
                .getViewModelProviderFactory()
        ).get(HruViewModel::class.java)

        mTTSFactory = getControllerCompositionRoot().getTTSFactory()

        setContentView(mHruView.getViewBinding().root)
    }

    override fun onStart() {
        super.onStart()
        mHruView.registerLister(this)
        mHruViewModel.attachObserver(this)
    }

    override fun onStop() {
        super.onStop()
        mHruView.unregisterListener(this)
        mHruViewModel.removeObserver()
        mTTSFactory.unregister()
    }

    override fun getFragmentFrame(): FrameLayout {
        TODO("Not yet implemented")
    }

    override fun onClickHappy() {
        mHruViewModel.executeHappyClickEvent()
    }

    override fun onClickSad() {
        mHruViewModel.executeSadClickEvent()
    }


    override fun openHomeScreen() {
        getControllerCompositionRoot().getScreenNavigatior().navigateToHomeScreen()
        finish()
    }

    override fun openVideoPlayerScreen() {
        getControllerCompositionRoot().getScreenNavigatior().navigateToVideoPlayerScreen()
    }

    override fun onTTSinitialized() {
        mTTSFactory.play(mHruView.getViewBinding().tvHru.text.toString())
    }
}