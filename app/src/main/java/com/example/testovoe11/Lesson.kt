package com.example.testovoe11

import com.google.gson.annotations.SerializedName

data class Lesson(

    @SerializedName("name") val name : String,
    @SerializedName("tema") val tema : String,
    @SerializedName("text") val text : String
)
