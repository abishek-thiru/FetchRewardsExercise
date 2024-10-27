package com.fetch.fetchrewardsexercise.ui.fetch_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fetch.fetchrewardsexercise.domain.util.DataResult
import com.fetch.fetchrewardsexercise.domain.repository.FetchRepository
import kotlinx.coroutines.launch

class FetchViewModel(
    private val repository: FetchRepository,
): ViewModel() {

    var state:FetchRewardState by mutableStateOf(FetchRewardState())
        private set

    init {
        fetchRewardsApi()
    }

    fun onAction(fetchAction: FetchAction) {
        when (fetchAction) {
            FetchAction.OnRefreshClick -> fetchRewardsApi()
            is FetchAction.OnExpandToggle -> {
                val updatedRewards = state.expandedStateMap.toMutableMap().apply {
                    this[fetchAction.listId] = !(this[fetchAction.listId] ?: false)
                }
                state = state.copy(expandedStateMap = updatedRewards)
            }
        }
    }

    private fun fetchRewardsApi() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            when (val result = repository.getFetchRewards()) {
                is DataResult.Success -> {
                        state = state.copy(
                            rewards = result.data,
                            isLoading = false
                        )
                }

                is DataResult.Error -> {
                    result.message?.let {
                        state = state.copy(
                            rewards = null,
                            isLoading = false,
                            error = result.message,
                            expandedStateMap = mapOf()
                        )
                    }
                }
            }
        }
    }
}