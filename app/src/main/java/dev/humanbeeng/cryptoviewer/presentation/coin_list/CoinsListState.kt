package dev.humanbeeng.cryptoviewer.presentation.coin_list

import dev.humanbeeng.cryptoviewer.domain.model.Coin

data class CoinsListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
