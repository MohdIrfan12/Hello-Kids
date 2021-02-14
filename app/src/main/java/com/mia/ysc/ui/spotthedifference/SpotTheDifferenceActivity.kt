package com.mia.ysc.ui.spotthedifference

import android.os.Bundle
import android.widget.FrameLayout
import com.mia.ysc.R
import com.mia.ysc.ui.common.controllers.BaseActivity
import com.mia.ysc.ui.common.tts.TTSFactory

class SpotTheDifferenceActivity : BaseActivity(), SpotTheDifferenceView.Listener,
    TTSFactory.Listener {

    private var mArray = arrayOf("Exercise 1", "Exercise 2", "Exercise 3")
    private lateinit var mSpotTheDifferenceView: SpotTheDifferenceView
    private lateinit var mTTSFactory: TTSFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mTTSFactory = getControllerCompositionRoot().getTTSFactory()
        mSpotTheDifferenceView =
            getControllerCompositionRoot().getViewFactory().getSpotTheDifferenceView(null, this)
        setContentView(mSpotTheDifferenceView.getViewBinding().root)
    }

    override fun onStart() {
        super.onStart()
        mSpotTheDifferenceView.registerLister(this)
        mSpotTheDifferenceView.bindArray(mArray)
    }

    override fun onStop() {
        super.onStop()
        mSpotTheDifferenceView.unregisterListener(this)
        mTTSFactory.unregister()
    }

    override fun getFragmentFrame(): FrameLayout {
        TODO("Not yet implemented")
    }

    override fun onPageSelected(position: Int) {
    }

    override fun onNavigationUpClicked() {
        finish()
    }

    override fun onTTSinitialized() {
        mTTSFactory.play(getString(R.string.text_spot_the_difference_among))
    }
}