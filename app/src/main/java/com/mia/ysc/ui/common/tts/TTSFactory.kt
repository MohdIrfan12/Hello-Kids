package com.mia.ysc.ui.common.tts

import android.app.Activity
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.*

/**
 * Created by Mohd Irfan on 12/2/21.
 */
class TTSFactory(private val mActivity: Activity) : TextToSpeech.OnInitListener {

    private var tts: TextToSpeech
    private var mListener: Listener? = null

    init {
        tts = TextToSpeech(mActivity, this);
        if (mActivity is Listener) {
            mListener = mActivity as Listener
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result: Int = tts.setLanguage(Locale.US)
            // tts.setPitch(5); // set pitch level

            // tts.setSpeechRate(2); // set speech speed rate
            if (result == TextToSpeech.LANG_MISSING_DATA
                || result == TextToSpeech.LANG_NOT_SUPPORTED
            ) {
                Log.e("TTS", "Language is not supported")
            } else {
                Log.e("TTS", "Language is supported")
                mListener?.onTTSinitialized()
            }
        } else {
            Log.e("TTS", "Initilization Failed")
        }
    }

    fun play(text: String) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    fun unregister() {
        tts.stop()
    }

    interface Listener {
        fun onTTSinitialized()
    }
}