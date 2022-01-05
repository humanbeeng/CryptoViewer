package dev.humanbeeng.cryptoviewer.presentation.coin_details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowRow
import dev.humanbeeng.cryptoviewer.data.remote.dto.TeamMember
import dev.humanbeeng.cryptoviewer.presentation.coin_details.components.CoinTag
import dev.humanbeeng.cryptoviewer.presentation.coin_details.components.TeamListItem


@Composable
fun CoinDetailsScreen(coinDetailsViewModel: CoinDetailsViewModel = hiltViewModel()) {

    val state = coinDetailsViewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        state.coinDetails?.let { coinDetails ->
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${coinDetails.rank} ${coinDetails.name} ${coinDetails.symbol}",
                            style = MaterialTheme.typography.h2, modifier = Modifier.weight(8f),
                        )
                        Text(
                            text = if (coinDetails.isActive) "Active" else "Inactive",
                            color = if (coinDetails.isActive) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            modifier = Modifier.weight(2f)
                        )

                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(text = coinDetails.description, style = MaterialTheme.typography.body2)

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(text = "Tags", style = MaterialTheme.typography.h3)

                    Spacer(modifier = Modifier.height(15.dp))

                    FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        coinDetails.tags.forEach { tag ->
                            CoinTag(tag = tag)
                        }

                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(text = "Team Members", style = MaterialTheme.typography.h3)

                    Spacer(modifier = Modifier.height(15.dp))
                }

                items(coinDetails.team) { teamMember: TeamMember ->
                    TeamListItem(
                        teamMember = teamMember,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )
                    Divider()
                }
            }
        }
    }

}

