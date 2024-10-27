package com.fetch.fetchrewardsexercise.domain.repository

import com.fetch.fetchrewardsexercise.domain.util.DataResult
import com.fetch.fetchrewardsexercise.domain.model.GroupedRewards

interface FetchRepository {
    suspend fun getFetchRewards(): DataResult<List<GroupedRewards>?>
}