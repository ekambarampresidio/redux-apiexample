package com.example.core.data

import okhttp3.ResponseBody
import retrofit2.Response

interface Repository {
    suspend fun getData() : Response<ResponseBody>
}