package com.mia.ysc.ui.math

import android.os.Bundle
import android.widget.FrameLayout
import com.mia.ysc.R
import com.mia.ysc.ui.common.controllers.BaseActivity
import com.mia.ysc.ui.common.tts.TTSFactory

class MathActivity : BaseActivity(), MathView.Listener, TTSFactory.Listener {

    private lateinit var mMathView: MathView
    private lateinit var mTTSFactory: TTSFactory
    private var mAlphabetsArray = arrayOf("Addition", "Subtraction", "Product/Multiplication")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mMathView = getControllerCompositionRoot().getViewFactory().getMathView(null, this)
        mTTSFactory = getControllerCompositionRoot().getTTSFactory()
        setContentView(mMathView.getViewBinding().root)
    }

    override fun onStart() {
        super.onStart()
        mMathView.registerLister(this)
    }

    override fun onStop() {
        super.onStop()
        mMathView.unregisterListener(this)
        mTTSFactory.unregister()
    }

    override fun getFragmentFrame(): FrameLayout {
        TODO("Not yet implemented")
    }

    override fun onNavigationUpClicked() {
        finish()
    }

    override fun onTTSinitialized() {
        mMathView.initViewPagerAndTabs()
        mMathView.bindAlphabetArray(mAlphabetsArray)
    }

    override fun onPageSelected(position: Int) {
        when (position) {
            0 -> playSoundForAddition()
            1 -> playSoundForSubstraction()
            2 -> playSoundForMultiplication()
        }
    }

    private fun playSoundForAddition() {
        mTTSFactory.play(getString(R.string.text_play_addition))
    }

    private fun playSoundForSubstraction() {
        mTTSFactory.play(getString(R.string.text_play_subs))
    }

    private fun playSoundForMultiplication() {
        mTTSFactory.play(getString(R.string.text_play_mul))
    }

    override fun onClickExerciseOne() {
        getControllerCompositionRoot().getScreenNavigatior().navigateToMathExerciseScreen(0)
    }

    override fun onClickExerciseTwo() {
        getControllerCompositionRoot().getScreenNavigatior().navigateToMathExerciseScreen(1)
    }

    override fun onClickExerciseThree() {
        getControllerCompositionRoot().getScreenNavigatior().navigateToMathExerciseScreen(2)
    }
}