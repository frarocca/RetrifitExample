package com.example.myretrofitexample.Network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL =
    "http://10.0.0.172:8842"



// Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
// full Kotlin compatibility.

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


//Retrofit needs the base URI for the web service, and a converter factory to build a web services API.
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


// GET "http://10.0.0.172:8842/simuapp/currentTime"
// Response: {"time":"12.42"}
interface SimulatorApiService {
    @GET("simuapp/currentTime")
    suspend fun currentTime(): Response<SimulatorTime>
}


//object declarations to create a singleton pattern.
//ensures that one, and only one, instance of an object is created, has one global point of access to that object.
//Object declaration's initialization is thread-safe and done at first access.

object SimulatorApi {
    val retrofitService : SimulatorApiService by lazy {
        retrofit.create(SimulatorApiService::class.java) }
}