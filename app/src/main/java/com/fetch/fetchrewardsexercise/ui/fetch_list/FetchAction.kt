package com.fetch.fetchrewardsexercise.ui.fetch_list

sealed interface FetchAction {
    data object OnRefreshClick :FetchAction
    data class OnExpandToggle(val listId: Int): FetchAction
}