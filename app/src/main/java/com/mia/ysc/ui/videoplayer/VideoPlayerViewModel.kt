package com.mia.ysc.ui.questionlist


import android.annotation.SuppressLint
import android.content.Context
import android.util.SparseArray
import androidx.lifecycle.ViewModel
import at.huber.youtubeExtractor.VideoMeta
import at.huber.youtubeExtractor.YouTubeExtractor
import at.huber.youtubeExtractor.YtFile
import com.mia.ysc.ui.videoplayer.VideoPlayerViewModelObserver


/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class VideoPlayerViewModel() : ViewModel() {

    private val YOUTUBE_URL = "https://www.youtube.com/watch?v=w3Wluvzoggg"
    private var fileURL = ""
    private var mObserver: VideoPlayerViewModelObserver? = null

    fun attachObserver(observer: VideoPlayerViewModelObserver?) {
        this.mObserver = observer;
    }

    fun removeObserver() {
        this.mObserver = null;
    }

    fun getPlaybackUrl(context: Context) {
        if (!fileURL.isNullOrEmpty()) {
            mObserver?.onDownloadeddFileUrl(fileURL)
        }
        val mExtractor = @SuppressLint("StaticFieldLeak") object : YouTubeExtractor(context) {
            override fun onExtractionComplete(
                ytFiles: SparseArray<YtFile>?,
                videoMeta: VideoMeta?
            ) {
                if (ytFiles != null) {
                    val itag = 22
                    fileURL = ytFiles[itag].url
                    mObserver?.onDownloadeddFileUrl(fileURL)
                }
            }
        }
        mExtractor.extract("https://www.youtube.com/watch?v=w3Wluvzoggg",
            true, true)
    }
}