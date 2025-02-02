package com.example.ahnhn.ince

import com.example.ahnhn.dcl.Horoscope
import retrofit2.http.GET
import retrofit2.http.Query

interface InHo {

//    https://horoscope-app-api.vercel.app/api/v1/get-horoscope/daily?sign=Gemini&day=TODAY

    // "/" и что идёт до знака "?"

    @GET("daily")

    // параметры после "?"

    fun Give(
        @Query("sign") zodiacName : String,
        @Query("day") d : String = "TODAY"
    ) : retrofit2.Call<Horoscope>

}