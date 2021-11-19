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


// GET "http://10.0.0.172:8842/simuapp/currentTime"
// Response: {"time":"12.42"}
interface SimulatorApiService {
    @GET("simuapp/currentTime")
    fun currentTime(): Response<SimulatorTime>
}


//object declarations to create a singleton pattern.
//ensures that one, and only one, instance of an object is created, has one global point of access to that object.
//Object declaration's initialization is thread-safe and done at first access.

object SimulatorApi {
    val retrofitService : SimulatorApiService by lazy {
        retrofit.create(SimulatorApiService::class.java) }
}