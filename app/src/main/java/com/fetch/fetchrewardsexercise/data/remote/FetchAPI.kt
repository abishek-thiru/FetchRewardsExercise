package com.fetch.fetchrewardsexercise.data.remote

import com.fetch.fetchrewardsexercise.domain.model.FetchReward
import retrofit2.Response
import retrofit2.http.GET

interface FetchAPI {
    @GET("hiring.json")
    suspend fun getFetchRewards(): Response<List<FetchReward>>
}