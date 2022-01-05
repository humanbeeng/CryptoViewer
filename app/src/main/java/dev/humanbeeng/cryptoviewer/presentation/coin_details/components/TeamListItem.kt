package dev.humanbeeng.cryptoviewer.presentation.coin_details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import dev.humanbeeng.cryptoviewer.data.remote.dto.TeamMember

@Composable
fun TeamListItem(modifier: Modifier = Modifier, teamMember: TeamMember) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
        Text(text = teamMember.name, style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = teamMember.position, style = MaterialTheme.typography.body2, fontStyle = FontStyle.Italic)
    }

}