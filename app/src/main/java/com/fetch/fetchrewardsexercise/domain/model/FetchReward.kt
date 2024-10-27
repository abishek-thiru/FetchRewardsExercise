package com.fetch.fetchrewardsexercise.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FetchReward(
    @SerializedName("id") @Expose val id: Int,
    @SerializedName("listId") @Expose val listId: Int,
    @SerializedName("name") @Expose val name: String? = null
)
