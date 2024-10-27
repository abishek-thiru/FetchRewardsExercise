package com.fetch.fetchrewardsexercise.ui.fetch_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.fetch.fetchrewardsexercise.ui.fetch_list.components.ErrorScreen
import com.fetch.fetchrewardsexercise.ui.fetch_list.components.ExpandableList
import org.koin.androidx.compose.koinViewModel

@Composable
fun FetchScreenRoot(
    modifier: Modifier = Modifier,
    viewModel: FetchViewModel = koinViewModel()
) {
    FetchScreen(
        modifier = modifier,
        state = viewModel.state,
        onAction = viewModel::onAction
    )
}

@Composable
fun FetchScreen(
    modifier: Modifier = Modifier,
    state: FetchRewardState,
    onAction: (FetchAction) -> Unit
) {

    Box(modifier = modifier.fillMaxSize()) {
        ExpandableList(
            state = state,
            onExpandToggle = {
                onAction(FetchAction.OnExpandToggle(it))
            }
        )

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }

        state.error?.let { it ->
            ErrorScreen(
                error = it,
                onRefreshClick = { onAction(it) }
            )
        }
    }

}