package com.mia.ysc.ui.videoplayer

import com.mia.ysc.databinding.ActivityVideoPlayerBinding
import com.mia.ysc.ui.common.views.MvvmView

/**
 * Created by Mohd Irfan on 11/2/21.
 */
interface VideoPlayerView : MvvmView<ActivityVideoPlayerBinding> {

    fun initializePlayer(url: String)
    fun releasePlayer()
    fun hideSystemUi()
}