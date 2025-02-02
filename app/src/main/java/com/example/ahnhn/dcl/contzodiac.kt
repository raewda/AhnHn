package com.example.ahnhn.dcl

import com.example.ahnhn.ince.InHor
import com.example.ahnhn.ince.NetworkZodiacRepository
import com.example.ahnhn.ince.ZodiacRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val zodiacRepository: ZodiacRepository
}

class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://json.astrologyapi.com/v1/sun_sign_prediction/daily/:zodiacName"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: InHor by lazy {
        retrofit.create(InHor::class.java)
    }

    override val zodiacRepository: ZodiacRepository by lazy {
        NetworkZodiacRepository(retrofitService)
    }
}
