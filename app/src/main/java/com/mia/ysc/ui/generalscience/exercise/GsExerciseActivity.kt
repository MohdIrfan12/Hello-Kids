package com.mia.ysc.ui.english.exercise

import android.os.Bundle
import android.widget.FrameLayout
import androidx.lifecycle.lifecycleScope
import com.mia.ysc.R
import com.mia.ysc.ui.common.controllers.BaseActivity
import com.mia.ysc.ui.common.tts.TTSFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GsExerciseActivity : BaseActivity(), GsExerciseView.Listener, TTSFactory.Listener {

    private lateinit var mGsExerciseView: GsExerciseView
    private lateinit var mTTSFactory: TTSFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mGsExerciseView = getControllerCompositionRoot().getViewFactory().getGsExerciseView(null)
        mTTSFactory = getControllerCompositionRoot().getTTSFactory()
        setContentView(mGsExerciseView.getViewBinding().root)
    }

    override fun onTTSinitialized() {}

    override fun getFragmentFrame(): FrameLayout {
        TODO("Not yet implemented")
    }

    override fun onStart() {
        super.onStart()
        mGsExerciseView.registerLister(this)
    }

    override fun onStop() {
        super.onStop()
        mGsExerciseView.unregisterListener(this)
        mTTSFactory.unregister()
    }

    override fun onNavigationUpClicked() {
        finish()
    }

    override fun displayError() {
        getControllerCompositionRoot().getMessageDisplayer().showError()
    }

    override fun onClickSubmit() {
        mTTSFactory.play(getString(R.string.text_excercise_completion_msg))
        mGsExerciseView.showProgressBar()
        lifecycleScope.launch(Dispatchers.IO) {
            delay(5 * 1000)
            withContext(Dispatchers.Main) {
                mGsExerciseView.hideProgressBar()
                finish()
            }
        }
    }
}