package com.fetch.fetchrewardsexercise.ui.fetch_list.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fetch.fetchrewardsexercise.domain.model.FetchReward
import com.fetch.fetchrewardsexercise.ui.fetch_list.FetchRewardState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExpandableList(
    state: FetchRewardState,
    onExpandToggle: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .animateContentSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        state.rewards?.forEach { (listId, rewards) ->
            stickyHeader {
                ListHeader(
                    listId = listId,
                    isExpanded = state.expandedStateMap[listId] ?: false,
                    onClick = {
                        onExpandToggle(listId)
                    }
                )
            }
            if (state.expandedStateMap[listId] == true) {
                fetchRewards(rewards)
            }
        }
    }
}

/*
LazyListScope is used to create nested lazy column. This way it isn't
creating multiple items, but reuses the already composed items.
*/
fun LazyListScope.fetchRewards(items: List<FetchReward>) {
    items(
        items = items,
        itemContent = {
            FetchRewardItem(it)
        }
    )
}