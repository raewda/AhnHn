package com.example.ahnhn.ince

import retrofit2.http.GET
import retrofit2.http.Query

interface InHor {

    @GET("./sun_sign_prediction/daily/" + zodiacName)
    suspend fun zodiacFilter(
        @Query("zodiacName") zodiacName: String
    )
}