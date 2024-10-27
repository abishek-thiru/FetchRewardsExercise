package com.fetch.fetchrewardsexercise.ui.fetch_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.fetch.fetchrewardsexercise.R
import com.fetch.fetchrewardsexercise.domain.model.FetchReward

@Composable
fun FetchRewardItem(
    fetchReward: FetchReward
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(MaterialTheme.colorScheme.surfaceContainer)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.id_value, fetchReward.id)
        )
        Text(
            text = stringResource(R.string.name_value, fetchReward.name?: "")
        )
    }
}