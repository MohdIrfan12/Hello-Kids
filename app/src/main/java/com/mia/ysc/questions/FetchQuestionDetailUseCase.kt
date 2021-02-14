package com.mia.ysc.questions

import com.mia.ysc.networking.question.FetchQuestionDetailEndpoint
import com.mia.ysc.common.observer.BaseObservable
import com.mia.ysc.networking.question.QuestionSchema

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class FetchQuestionDetailUseCase(private val mFetchQuestionDetailEndpoint: FetchQuestionDetailEndpoint) :
    BaseObservable<FetchQuestionDetailUseCase.Listener>() {

    interface Listener {
        fun onQuestionDetailFetched(questionDetail: QuestionDetail)
        fun onQuestionDetailFetchFailed()
    }

    fun fetchQuestionDetailAndNotify(questionId: String?) {
        mFetchQuestionDetailEndpoint.fetchQuestions(questionId,
            object : FetchQuestionDetailEndpoint.Listener {
                override fun onQuestionDetailFetched(questionSchema: QuestionSchema?) {
                    notifySucess(questionSchema)
                }

                override fun onQuestionDetailFetchFailed() {
                    notifyFailure()
                }
            })
    }

    private fun notifySucess(mQuestionSchema: QuestionSchema?) {
        val questionDetail = QuestionDetail()
        mQuestionSchema?.let {
            questionDetail.mId = it.mId;
            questionDetail.mTitle = it.mTitle;
            questionDetail.mBody = it.mBody;
        }
        for (listener in getObserver()) {
            listener.onQuestionDetailFetched(questionDetail)
        }
    }

    private fun notifyFailure() {
        for (listener in getObserver()) {
            listener.onQuestionDetailFetchFailed()
        }
    }
}