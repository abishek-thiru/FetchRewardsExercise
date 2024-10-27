package com.fetch.fetchrewardsexercise.domain.util

import retrofit2.Response

suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): DataResult<T> {
    return try {
        val response = apiCall()
        if (response.isSuccessful) {
            response.body()?.let {
                DataResult.Success(it)
            } ?: DataResult.Error(message = "Something went wrong, please try again later.")
        } else {
            DataResult.Error(message = "Error Code: ${response.message()}")
        }
    } catch (e: Exception) {
        DataResult.Error(message = e.message ?: "Something went wrong, please try again later.")
    }
}