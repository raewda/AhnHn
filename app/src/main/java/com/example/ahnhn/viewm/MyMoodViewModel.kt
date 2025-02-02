package com.example.ahnhn.viewm

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.ahnhn.dcl.Horoscope
import com.example.ahnhn.ince.InHo
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyMoodViewModel : ViewModel() {

    // то, что будет отображаться на экране

    val horoscopeData = MutableStateFlow(Horoscope())

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://horoscope-app-api.vercel.app/api/v1/get-horoscope/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // сделает за меня реализацию функции - от меня нихуя не надо, кроме как объявить

    private val horoscopeService = retrofit.create(InHo :: class.java)

    // обновляем стейт при передаче ему зз

    fun horoscopeGive(
        zodiacName : String
    ){
        horoscopeService.Give(zodiacName).enqueue(object : Callback<Horoscope> {


            // если удачно вызовет

            override fun onResponse(call: Call<Horoscope>, response: Response<Horoscope>) {

                if (response.body() != null){
                    horoscopeData.value = response.body()!!
                }

            }

            // если вызов с ошибкой

            override fun onFailure(call: Call<Horoscope>, t: Throwable) {
                Log.d("pizdec", t.message.toString())
            }

        })
    }
}