package dev.humanbeeng.cryptoviewer.presentation

sealed class Screens(val route: String) {
    object CoinsListScreen : Screens("coins_list_screen")
    object CoinDetailsScreen : Screens("coin_details_screen")
}
