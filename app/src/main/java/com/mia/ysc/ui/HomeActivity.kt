package com.mia.ysc.ui

import android.os.Bundle
import android.widget.FrameLayout
import com.mia.ysc.R
import com.mia.ysc.ui.common.controllers.BaseActivity
import com.mia.ysc.ui.common.tts.TTSFactory


class HomeActivity : BaseActivity(), HomeView.Listener, TTSFactory.Listener {

    private lateinit var mHomeView: HomeView
    private lateinit var mTTSFactory: TTSFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mHomeView = getControllerCompositionRoot().getViewFactory().getHomeView(null,this)
        mTTSFactory = getControllerCompositionRoot().getTTSFactory()
        setContentView(mHomeView.getViewBinding().root)
    }

    override fun getFragmentFrame(): FrameLayout {
        TODO("Not yet implemented")
    }

    override fun onStart() {
        super.onStart()
        mHomeView.registerLister(this)
    }

    override fun onStop() {
        super.onStop()
        mHomeView.unregisterListener(this)
        mTTSFactory.unregister()
    }

    override fun onClickEnglish() {
        getControllerCompositionRoot().getScreenNavigatior().navigateToEnglishScreen()
    }

    override fun onClickMath() {
        getControllerCompositionRoot().getScreenNavigatior().navigateToMathScreen()
    }

    override fun onClickES() {
        getControllerCompositionRoot().getScreenNavigatior().navigateToGsScreen()
    }

    override fun onClickSpotTheDifference() {
        getControllerCompositionRoot().getScreenNavigatior().navigateToSpotTheDifferenceScreen()
    }

    override fun onClickAddress() {
        getControllerCompositionRoot().getScreenNavigatior().navigateToAddressScreen()
    }

    override fun onClickWatchVideo() {
        getControllerCompositionRoot().getScreenNavigatior().navigateToVideoPlayerScreen()
    }

    override fun onClickPrize() {
        getControllerCompositionRoot().getScreenNavigatior().navigateToMathPrizeScreen()
    }

    override fun onTTSinitialized() {
        mTTSFactory.play(getString(R.string.text_welcome_message))
    }
}