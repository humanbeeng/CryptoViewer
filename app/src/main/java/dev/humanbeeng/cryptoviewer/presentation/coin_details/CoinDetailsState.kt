package dev.humanbeeng.cryptoviewer.presentation.coin_details

import dev.humanbeeng.cryptoviewer.domain.model.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coinDetails: CoinDetails? = null,
    val error: String = ""
)
