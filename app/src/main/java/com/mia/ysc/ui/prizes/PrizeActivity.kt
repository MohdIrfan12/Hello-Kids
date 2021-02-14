package com.mia.ysc.ui.prizes

import android.os.Bundle
import android.widget.FrameLayout
import com.mia.ysc.R
import com.mia.ysc.ui.common.controllers.BaseActivity
import com.mia.ysc.ui.common.tts.TTSFactory

class PrizeActivity : BaseActivity(), PrizeView.Listener, TTSFactory.Listener {

    private lateinit var mPrizeView: PrizeView
    private lateinit var mTTSFactory: TTSFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPrizeView =
            getControllerCompositionRoot().getViewFactory().getPrizeView(null)
        mTTSFactory = getControllerCompositionRoot().getTTSFactory()
        setContentView(mPrizeView.getViewBinding().root)
    }

    override fun onTTSinitialized() {
        mTTSFactory.play(getString(R.string.text_welcome_message))
    }

    override fun getFragmentFrame(): FrameLayout {
        TODO("Not yet implemented")
    }

    override fun onStart() {
        super.onStart()
        mPrizeView.registerLister(this)
    }

    override fun onStop() {
        super.onStop()
        mPrizeView.unregisterListener(this)
        mTTSFactory.unregister()
    }

    override fun onNavigationUpClicked() {
        finish()
    }
}