package com.mia.ysc.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import com.mia.ysc.ui.HomeView
import com.mia.ysc.ui.address.AddressView
import com.mia.ysc.ui.address.AddressViewImpl
import com.mia.ysc.ui.hru.HruView
import com.mia.ysc.ui.common.dialogs.promptdialog.PromptDialogView
import com.mia.ysc.ui.common.dialogs.promptdialog.PromptDialogViewImpl
import com.mia.ysc.ui.common.toolbar.ToolbarView
import com.mia.ysc.ui.english.EnglishAlphabetView
import com.mia.ysc.ui.english.exercise.*
import com.mia.ysc.ui.generalscience.GsView
import com.mia.ysc.ui.math.MathView
import com.mia.ysc.ui.prizes.PrizeView
import com.mia.ysc.ui.prizes.PrizeViewImpl
import com.mia.ysc.ui.questiondetail.*
import com.mia.ysc.ui.spotthedifference.SpotTheDifferenceView
import com.mia.ysc.ui.spotthedifference.SpotTheDifferenceViewImpl
import com.mia.ysc.ui.videoplayer.VideoPlayerView

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class ViewFactory(private val mLayoutInflater: LayoutInflater) {

    fun getToolbarView(@Nullable parent: ViewGroup?): ToolbarView {
        return ToolbarView(mLayoutInflater, parent)
    }

    fun getPromptDialogView(@Nullable parent: ViewGroup?): PromptDialogView {
        return PromptDialogViewImpl(mLayoutInflater)
    }

    fun getHruView(@Nullable parent: ViewGroup?): HruView {
        return HruViewImpl(mLayoutInflater, parent);
    }

    fun getVideoPlayerView(@Nullable parent: ViewGroup?): VideoPlayerView {
        return VideoPlayerViewImpl(mLayoutInflater, parent)
    }

    fun getHomeView(parent: ViewGroup?,activity: AppCompatActivity): HomeView {
        return HomeViewImpl(mLayoutInflater, parent, this,activity)
    }

    fun getEnglishAlphabetView(
        parent: ViewGroup?,
        activity: AppCompatActivity
    ): EnglishAlphabetView {
        return EnglishAlphabetViewImpl(mLayoutInflater, parent, this, activity)
    }

    fun getMathView(
        parent: ViewGroup?,
        activity: AppCompatActivity
    ): MathView {
        return MathViewImpl(mLayoutInflater, parent, this, activity)
    }

    fun getGsView(
        parent: ViewGroup?,
        activity: AppCompatActivity
    ): GsView {
        return GsViewImpl(mLayoutInflater, parent, this, activity)
    }

    fun getSpotTheDifferenceView(
        parent: ViewGroup?,
        activity: AppCompatActivity
    ): SpotTheDifferenceView {
        return SpotTheDifferenceViewImpl(mLayoutInflater, parent, this, activity)
    }

    fun getEnglishExerciseView(parent: ViewGroup?): EnglishExerciseView {
        return EnglishExerciseViewImpl(mLayoutInflater, parent, this)
    }

    fun getGsExerciseView(parent: ViewGroup?): GsExerciseView {
        return GsExerciseViewImpl(mLayoutInflater, parent, this)
    }

    fun getMathExerciseView(parent: ViewGroup?): MathExerciseView {
        return MathExerciseViewImpl(mLayoutInflater, parent, this)
    }

    fun getAddressView(parent: ViewGroup?): AddressView {
        return AddressViewImpl(mLayoutInflater, parent, this)
    }

    fun getPrizeView(parent: ViewGroup?): PrizeView {
        return PrizeViewImpl(mLayoutInflater, parent, this)
    }
}