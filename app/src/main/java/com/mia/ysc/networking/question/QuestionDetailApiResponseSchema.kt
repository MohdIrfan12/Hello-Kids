package com.mia.ysc.networking.question

import com.google.gson.annotations.SerializedName

/**
 * Created by Mohd Irfan on 29/12/20.
 *
 */
data class QuestionDetailApiResponseSchema(
    @SerializedName("items")
    var mQuestions: List<QuestionSchema>? = null
) {
    fun getQuestion(): QuestionSchema? {
        return mQuestions?.get(0)
    }
}