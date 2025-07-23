package com.example.core.data

import com.example.core.network.DataSource
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

internal class RepositoryImpl @Inject constructor(
    private val dataSource: DataSource
) : Repository {
    override suspend fun getData(): Response<ResponseBody> =
        dataSource.getData()
}