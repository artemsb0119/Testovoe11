package com.example.testovoe11

import com.google.gson.annotations.SerializedName

data class Quiz(

    @SerializedName("question") val question: String,
    @SerializedName("a") val a: String,
    @SerializedName("b") val b: String,
    @SerializedName("c") val c: String,
    @SerializedName("d") val d: String,
    @SerializedName("answer") val answer: String
)
