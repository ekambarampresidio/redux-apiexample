package com.example.core.network


import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

interface DataSource {
    suspend fun getData(): Response<ResponseBody>
}

internal class NetworkDataSource @Inject constructor(
    private val apiService: ApiService
) : DataSource {
    override suspend fun getData(): Response<ResponseBody> {
        return apiService.getData()
    }
}
