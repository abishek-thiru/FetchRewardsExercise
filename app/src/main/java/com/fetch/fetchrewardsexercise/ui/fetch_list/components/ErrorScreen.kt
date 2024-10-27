package com.fetch.fetchrewardsexercise.ui.fetch_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.fetch.fetchrewardsexercise.R
import com.fetch.fetchrewardsexercise.ui.fetch_list.FetchAction

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    error: String,
    onRefreshClick: (FetchAction) -> Unit
) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = error,
            textAlign = TextAlign.Center
        )

        Button(
            onClick = { onRefreshClick(FetchAction.OnRefreshClick) }
        ) {
            Text(text = stringResource(R.string.try_again))
        }
    }

}