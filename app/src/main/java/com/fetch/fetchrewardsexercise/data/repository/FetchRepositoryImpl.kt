package com.fetch.fetchrewardsexercise.data.repository

import android.content.Context
import com.fetch.fetchrewardsexercise.R
import com.fetch.fetchrewardsexercise.domain.util.DataResult
import com.fetch.fetchrewardsexercise.data.remote.FetchAPI
import com.fetch.fetchrewardsexercise.domain.model.FetchReward
import com.fetch.fetchrewardsexercise.domain.model.GroupedRewards
import com.fetch.fetchrewardsexercise.domain.util.ConnectivityChecker
import com.fetch.fetchrewardsexercise.domain.util.safeApiCall
import com.fetch.fetchrewardsexercise.domain.repository.FetchRepository

class FetchRepositoryImpl(
    private val fetchAPI: FetchAPI,
    private val connectivityChecker: ConnectivityChecker,
    private val context: Context
) : FetchRepository {
    override suspend fun getFetchRewards(): DataResult<List<GroupedRewards>?> {
        if (!connectivityChecker.isConnected()) {
            return DataResult.Error(message = context.getString(R.string.no_internet))
        }
        val result = safeApiCall { fetchAPI.getFetchRewards() }
        when (result) {
            is DataResult.Success -> {
                val groupedResult = sortAndFilterRewards(result.data)
                return DataResult.Success(groupedResult)
            }

            is DataResult.Error -> {
                return DataResult.Error(message = result.message?: context.getString(R.string.unknown_error))
            }
        }


    }

    private fun sortAndFilterRewards(input: List<FetchReward>?): List<GroupedRewards>? {
        return input?.filter { !it.name.isNullOrBlank() }  // Filter null/blank names
            ?.sortedWith(compareBy({ it.listId }, { it.name }))
            ?.groupBy { it.listId }
            ?.map { (listId, item) ->
                GroupedRewards(listId, item)
            }
    }
}