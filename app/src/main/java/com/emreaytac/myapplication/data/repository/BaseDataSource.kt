package com.emreaytac.myapplication.data.repository

import android.util.Log
import com.emreaytac.myapplication.data.utils.Constants.CONNECTION_ERROR
import com.emreaytac.myapplication.data.utils.Constants.UNKNOWN_ERROR
import com.emreaytac.myapplication.domain.Resource
import retrofit2.Response
import java.io.IOException

abstract class BaseDataSource {
    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Resource<T> {

        try {

            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    return Resource.Success(body)
                }
            }
            return when {
                response.code() >= 500 -> {
                    error(UNKNOWN_ERROR)
                }
                else -> {
                    error(response.message() ?: UNKNOWN_ERROR)
                }
            }
        } catch (e: Exception) {
            return when(e){
                is IOException -> error(e.localizedMessage ?: CONNECTION_ERROR)
                else -> error(e.localizedMessage ?: UNKNOWN_ERROR)
            }
        }
    }

    private fun <T> error(message: String): Resource<T> {
        Log.e("remoteDataSource", message)
        return Resource.Error(message)
    }
}