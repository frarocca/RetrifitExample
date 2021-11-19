package com.example.myretrofitexample.Network

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "http://10.0.0.172:8842"

//Retrofit needs the base URI for the web service, and a converter factory to build a web services API.
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

// {"time":"12.42"}
interface SimulatorApiService {
    @GET("simuapp/currentTime")
    fun currentTime(): Response<SimulatorTime>
}