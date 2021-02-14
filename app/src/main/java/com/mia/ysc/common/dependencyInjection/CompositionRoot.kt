package com.mia.ysc.common.dependencyInjection

import android.app.Application
import com.mia.ysc.common.eventbus.EventBus
import com.mia.ysc.networking.Constants
import com.mia.ysc.networking.StackoverflowApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class CompositionRoot(private val mApplication: Application) {
    private val mRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    private val mEventBus by lazy {
        EventBus()
    }

    fun getStackOverFlowApi(): StackoverflowApi {
        return mRetrofit.create(StackoverflowApi::class.java)
    }

    fun getEventBus(): EventBus {
        return mEventBus;
    }
}