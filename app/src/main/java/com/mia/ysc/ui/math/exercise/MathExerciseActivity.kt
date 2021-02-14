package com.mia.ysc.ui.english.exercise

import android.content.Context
import android.content.Intent
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

class MathExerciseActivity : BaseActivity(), MathExerciseView.Listener, TTSFactory.Listener {

    companion object {

        private const val KEY_OPERATION_TYPE = "operationtype"

        fun start(mContext: Context, operationType: Int) {
            val intent = Intent(mContext, MathExerciseActivity::class.java)
            intent.putExtra(KEY_OPERATION_TYPE, operationType)
            mContext.startActivity(intent)
        }
    }

    private lateinit var mMathExerciseView: MathExerciseView
    private lateinit var mTTSFactory: TTSFactory
    private var operationType = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        operationType = intent.getIntExtra(KEY_OPERATION_TYPE, 0)
        mMathExerciseView =
            getControllerCompositionRoot().getViewFactory().getMathExerciseView(null)
        mTTSFactory = getControllerCompositionRoot().getTTSFactory()
        setContentView(mMathExerciseView.getViewBinding().root)
    }

    override fun onTTSinitialized() {}

    override fun getFragmentFrame(): FrameLayout {
        TODO("Not yet implemented")
    }

    override fun onStart() {
        super.onStart()
        mMathExerciseView.registerLister(this)
        when(operationType){
            0 -> mMathExerciseView.setDataForAddition()
            1 -> mMathExerciseView.setDataForSubtraction()
            2 -> mMathExerciseView.setDataForMultiplication()
        }
    }

    override fun onStop() {
        super.onStop()
        mMathExerciseView.unregisterListener(this)
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
        mMathExerciseView.showProgressBar()
        lifecycleScope.launch(Dispatchers.IO) {
            delay(5 * 1000)
            withContext(Dispatchers.Main) {
                mMathExerciseView.  hideProgressBar()
                finish()
            }
        }
    }
}