package com.example.ahnhn.dcl

import com.google.gson.annotations.SerializedName

data class Horoscope(
    @SerializedName("sign" ) var sign : String? = null,
    @SerializedName("text" ) var text : String? = null,
    @SerializedName("date" ) var date : String? = null,
    @SerializedName("type" ) var type : String? = null
)

