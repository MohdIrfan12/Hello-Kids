package com.mia.ysc.common

import android.app.Application
import com.mia.ysc.R
import com.mia.ysc.common.dependencyInjection.CompositionRoot
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class CommonApplication : Application() {

    private val mCompositionRoot by lazy {
        CompositionRoot(this)
    }
    private val REGULAR_FONT_PATH = "font/Avenir-Heavy.ttf"

    override fun onCreate() {
        initCalligraphy()
        super.onCreate()
    }

    fun getCompositionRoot(): CompositionRoot {
        return mCompositionRoot;
    }

    private fun initCalligraphy() {
        ViewPump.init(
            ViewPump.builder().addInterceptor(
                CalligraphyInterceptor(
                    CalligraphyConfig.Builder()
                        .setDefaultFontPath(REGULAR_FONT_PATH)
                        .setFontAttrId(R.attr.fontPath)
                        .build()
                )
            ).build()
        )
    }
}