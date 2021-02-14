package com.mia.ysc.ui.common.screensnavigator

import android.content.Context
import android.content.Intent
import com.mia.ysc.ui.HomeActivity
import com.mia.ysc.ui.address.AddressActivity
import com.mia.ysc.ui.common.fragmentframehelper.FragmentFrameHelper
import com.mia.ysc.ui.english.EnglishActivity
import com.mia.ysc.ui.english.exercise.EnglishExerciseActivity
import com.mia.ysc.ui.english.exercise.GsExerciseActivity
import com.mia.ysc.ui.english.exercise.MathExerciseActivity
import com.mia.ysc.ui.generalscience.GsActivity
import com.mia.ysc.ui.math.MathActivity
import com.mia.ysc.ui.prizes.PrizeActivity
import com.mia.ysc.ui.spotthedifference.SpotTheDifferenceActivity
import com.mia.ysc.ui.videoplayer.VideoPlayerActivity

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class ScreenNavigatior(
    private val mContext: Context,
    private val mFragmentFrameHelper: FragmentFrameHelper
) {

    fun navigateToVideoPlayerScreen() {
        mContext.startActivity(Intent(mContext, VideoPlayerActivity::class.java))
    }

    fun navigateToHomeScreen() {
        mContext.startActivity(Intent(mContext, HomeActivity::class.java))
    }

    fun navigateToEnglishScreen() {
        mContext.startActivity(Intent(mContext, EnglishActivity::class.java))
    }

    fun navigateToMathScreen() {
        mContext.startActivity(Intent(mContext, MathActivity::class.java))
    }

    fun navigateToGsScreen() {
        mContext.startActivity(Intent(mContext, GsActivity::class.java))
    }

    fun navigateToSpotTheDifferenceScreen() {
        mContext.startActivity(Intent(mContext, SpotTheDifferenceActivity::class.java))
    }

    fun navigateToAddressScreen() {
        mContext.startActivity(Intent(mContext, AddressActivity::class.java))
    }

    fun navigateToEnglishExerciseScreen() {
        mContext.startActivity(Intent(mContext, EnglishExerciseActivity::class.java))
    }

    fun navigateToGsExerciseScreen() {
        mContext.startActivity(Intent(mContext, GsExerciseActivity::class.java))
    }

    fun navigateToMathExerciseScreen(operationType: Int) {
       MathExerciseActivity.start(mContext, operationType)
    }

    fun navigateToMathPrizeScreen() {
        mContext.startActivity(Intent(mContext, PrizeActivity::class.java))
    }
}