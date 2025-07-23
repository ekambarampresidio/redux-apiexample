package com.example.core.network


import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

const val DATA = "artworks/129884"

interface ApiService {

    @GET(DATA)
    suspend fun getData(): Response<ResponseBody>
}