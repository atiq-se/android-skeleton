package com.example.androidskeleton.data.responses

import com.google.gson.annotations.SerializedName

data class MyResponse(
    @SerializedName("questions") val questionsList: List<Question>,
)

data class Question(
    @SerializedName("question") val question: String,
    @SerializedName("answers") val answers: Answers,
    @SerializedName("questionImageUrl") val questionImageUrl: String? = null,
    @SerializedName("correctAnswer") val correctAnswer: String,
    @SerializedName("score") val score: Int
)

data class Answers(
    @SerializedName("A") val answersA: String,
    @SerializedName("B") val answersB: String,
    @SerializedName("C") val answersC: String,
    @SerializedName("D") val answersD: String,
)