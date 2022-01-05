package dev.humanbeeng.cryptoviewer.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.humanbeeng.cryptoviewer.presentation.coin_details.CoinDetailsScreen
import dev.humanbeeng.cryptoviewer.presentation.coin_list.CoinsListScreen
import dev.humanbeeng.cryptoviewer.presentation.theme.CryptoViewerTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoViewerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screens.CoinsListScreen.route
                    ) {
                        composable(route = Screens.CoinsListScreen.route) {
                            CoinsListScreen(navController = navController)
                        }

                        composable(route = Screens.CoinDetailsScreen.route + "/{coinId}") {
                            CoinDetailsScreen()
                        }
                    }


                }
            }
        }
    }
}
