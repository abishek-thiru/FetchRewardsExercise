package com.fetch.fetchrewardsexercise.ui.fetch_list

import com.fetch.fetchrewardsexercise.domain.model.GroupedRewards

data class FetchRewardState(
    val rewards: List<GroupedRewards>? = null,
    val isLoading: Boolean = false,
    val expandedStateMap: Map<Int, Boolean> = mapOf(),
    val error: String? = null
)
