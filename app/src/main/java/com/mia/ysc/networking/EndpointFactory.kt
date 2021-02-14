package com.mia.ysc.networking

import com.mia.ysc.networking.question.FetchQuestionDetailEndpoint
import com.mia.ysc.networking.question.FetchQuestionListEndpoint
import com.mia.ysc.networking.StackoverflowApi

/**
 * Created by Mohd Irfan on 07/01/21.
 */
class EndpointFactory(private val mStackoverflowApi: StackoverflowApi) {

    fun getQuestionListEndpoint(): FetchQuestionListEndpoint {
        return FetchQuestionListEndpoint(mStackoverflowApi)
    }

    fun getQuestionDetailEndpoint(): FetchQuestionDetailEndpoint {
        return FetchQuestionDetailEndpoint(mStackoverflowApi)
    }
}