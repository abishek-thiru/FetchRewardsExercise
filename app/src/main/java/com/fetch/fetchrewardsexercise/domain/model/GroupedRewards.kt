package com.fetch.fetchrewardsexercise.domain.model

data class GroupedRewards(
    val listId: Int,
    val items: List<FetchReward>
)