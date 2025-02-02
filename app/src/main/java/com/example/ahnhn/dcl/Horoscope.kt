package com.example.ahnhn.dcl

import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("date"           ) var date          : String? = null,
    @SerializedName("horoscope_data" ) var horoscopeData : String? = null
)

data class Horoscope(
    @SerializedName("data"    ) var data    : Status?    = Status(),
    @SerializedName("status"  ) var status  : Int?     = null,
    @SerializedName("success" ) var success : Boolean? = null
)

