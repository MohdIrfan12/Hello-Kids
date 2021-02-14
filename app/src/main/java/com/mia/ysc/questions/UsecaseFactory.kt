package com.mia.ysc.questions

import com.mia.ysc.networking.EndpointFactory
import com.mia.ysc.questions.FetchQuestionDetailUseCase
import com.mia.ysc.questions.FetchQuestionsListUseCase

/**
 * Created by Mohd Irfan on 07/01/21.
 */
class UsecaseFactory(private val endpoint: EndpointFactory) {

    fun getFetchQuestionsListUseCase(): FetchQuestionsListUseCase {
        return FetchQuestionsListUseCase(endpoint.getQuestionListEndpoint())
    }

    fun getFetchQuestionsDetailUseCase(): FetchQuestionDetailUseCase {
        return FetchQuestionDetailUseCase(endpoint.getQuestionDetailEndpoint())
    }
}