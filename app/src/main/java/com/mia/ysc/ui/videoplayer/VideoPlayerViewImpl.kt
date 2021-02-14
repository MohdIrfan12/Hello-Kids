package com.mia.ysc.ui.questiondetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.mia.ysc.databinding.ActivityVideoPlayerBinding
import com.mia.ysc.ui.common.views.BaseView
import com.mia.ysc.ui.videoplayer.VideoPlayerView

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class VideoPlayerViewImpl(
    layoutInflater: LayoutInflater,
    @Nullable viewGroup: ViewGroup?
) : BaseView<ActivityVideoPlayerBinding>(), VideoPlayerView {

    private var player: SimpleExoPlayer? = null
    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition: Long = 0

    init {
        setViewBinding(ActivityVideoPlayerBinding.inflate(layoutInflater, viewGroup, false))
    }

    override fun initializePlayer(url: String) {
        player = SimpleExoPlayer.Builder(getContext()).build()
        getViewBinding().videoView.setPlayer(player)
        val mediaItem = MediaItem.fromUri(url)
        player?.setMediaItem(mediaItem)
        player?.setPlayWhenReady(playWhenReady);
        player?.seekTo(currentWindow, playbackPosition);
        player?.playWhenReady = true
        player?.prepare();
    }

    override fun releasePlayer() {
        if (player != null) {
            playWhenReady = player?.playWhenReady!!
            playbackPosition = player?.currentPosition!!
            currentWindow = player?.currentWindowIndex!!
            player?.pause()
            player?.release()
            player = null
        }
    }

    override fun hideSystemUi() {
        getViewBinding().videoView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_LOW_PROFILE
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        )
    }
}