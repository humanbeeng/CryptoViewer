package dev.humanbeeng.cryptoviewer.presentation.coin_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.humanbeeng.cryptoviewer.domain.model.Coin

@Composable
fun CoinListItem(coin: Coin, onClick: (Coin) -> Unit) {
    Row(modifier = Modifier
        .padding(20.dp)
        .fillMaxWidth()
        .clickable { onClick(coin) }) {
        Text(
            text = "${coin.rank} ${coin.name} ${coin.symbol}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = if (coin.isActive) "Active" else "Inactive",
            color = if (coin.isActive) Green else Red,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(CenterVertically)

        )

    }
}