package com.example.feature.home.domain

import com.example.core.data.Repository
import okhttp3.ResponseBody
import retrofit2.Response

import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(): Response<ResponseBody> = repository.getData()
}