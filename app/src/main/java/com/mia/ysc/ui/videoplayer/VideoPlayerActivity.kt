package com.mia.ysc.ui.videoplayer

import android.os.Build
import android.os.Bundle
import android.widget.FrameLayout
import androidx.lifecycle.ViewModelProvider
import com.mia.ysc.ui.common.controllers.BaseActivity
import com.mia.ysc.ui.questionlist.VideoPlayerViewModel


class VideoPlayerActivity : BaseActivity(), VideoPlayerViewModelObserver {

    private lateinit var mVideoPlayerViewModel: VideoPlayerViewModel
    private lateinit var mVideoPlayerView: VideoPlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mVideoPlayerView = getControllerCompositionRoot().getViewFactory().getVideoPlayerView(null)

        mVideoPlayerViewModel = ViewModelProvider(
            this, getControllerCompositionRoot()
                .getViewModelProviderFactory()
        ).get(VideoPlayerViewModel::class.java)

        setContentView(mVideoPlayerView.getViewBinding().root)
    }

    override fun getFragmentFrame(): FrameLayout {
        TODO("Not yet implemented")
    }

    override fun onStart() {
        super.onStart()
        mVideoPlayerViewModel.attachObserver(this)
        if (Build.VERSION.SDK_INT >= 24) {
            mVideoPlayerViewModel.getPlaybackUrl(this)
        }
    }

    override fun onResume() {
        super.onResume()
        mVideoPlayerView.hideSystemUi()
        if (Build.VERSION.SDK_INT < 24) {
            mVideoPlayerViewModel.getPlaybackUrl(this)
        }
    }

    override fun onPause() {
        super.onPause()
        if (Build.VERSION.SDK_INT < 24) {
            mVideoPlayerView.releasePlayer()
        }
    }

    override fun onStop() {
        super.onStop()
        mVideoPlayerViewModel.removeObserver()
        if (Build.VERSION.SDK_INT >= 24) {
            mVideoPlayerView.releasePlayer()
        }
    }

    override fun onDownloadeddFileUrl(fileURL: String) {
        mVideoPlayerView.initializePlayer(fileURL)
    }
}