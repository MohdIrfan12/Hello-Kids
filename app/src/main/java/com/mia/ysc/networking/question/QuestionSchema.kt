package com.mia.ysc.networking.question

import com.google.gson.annotations.SerializedName
import com.mia.ysc.networking.user.UserSchema

/**
 * Created by Mohd Irfan on 29/12/20.
 *
 */
data class QuestionSchema(
    @SerializedName("title")
    val mTitle: String? = null,

    @SerializedName("question_id")
    val mId: String? = null,

    @SerializedName("body")
    val mBody: String? = null,

    @SerializedName("owner")
    val mOwner: UserSchema? = null
)