package com.mia.ysc.ui.generalscience

import android.os.Bundle
import android.widget.FrameLayout
import com.mia.ysc.R
import com.mia.ysc.ui.common.controllers.BaseActivity
import com.mia.ysc.ui.common.tts.TTSFactory

class GsActivity : BaseActivity(), GsView.Listener, TTSFactory.Listener{

    private lateinit var mGsView: GsView
    private lateinit var mTTSFactory: TTSFactory
    private var mAlphabetsArray = arrayOf("Plants", "Animals", "Human body", "Environment")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mGsView = getControllerCompositionRoot().getViewFactory().getGsView(null, this)
        mTTSFactory = getControllerCompositionRoot().getTTSFactory()
        setContentView(mGsView.getViewBinding().root)
    }

    override fun onTTSinitialized() {
        mGsView.initViewPagerAndTabs()
        mGsView.bindAlphabetArray(mAlphabetsArray)
    }

    override fun getFragmentFrame(): FrameLayout {
        TODO("Not yet implemented")
    }

    override fun onPageSelected(position: Int) {
        when (position) {
            0 -> playSoundForPlants()
            1 -> playSoundForAnimals()
            2 -> playSoundForHumanbody()
            3 -> playSoundForEnvirnment()
        }
    }

    private fun playSoundForPlants() {
        mTTSFactory.play(getString(R.string.text_play_plant))
    }

    private fun playSoundForAnimals() {
        mTTSFactory.play(getString(R.string.text_play_animal))
    }

    private fun playSoundForHumanbody() {
        mTTSFactory.play(getString(R.string.text_play_humanbody))
    }

    private fun playSoundForEnvirnment() {
        mTTSFactory.play(getString(R.string.text_play_env))
    }

    override fun onStart() {
        super.onStart()
        mGsView.registerLister(this)
    }

    override fun onStop() {
        super.onStop()
        mGsView.unregisterListener(this)
        mTTSFactory.unregister()
    }

    override fun onNavigationUpClicked() {
        finish()
    }

    override fun onExcerciseClick() {
        getControllerCompositionRoot().getScreenNavigatior().navigateToGsExerciseScreen()
    }
}