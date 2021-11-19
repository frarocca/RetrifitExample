package com.example.myretrofitexample.Network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val BASE_URL =
    "http://10.0.0.172:8842"

//Retrofit needs the base URI for the web service, and a converter factory to build a web services API.
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

