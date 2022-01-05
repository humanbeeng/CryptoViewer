package dev.humanbeeng.cryptoviewer.domain.repository

import dev.humanbeeng.cryptoviewer.common.Resource
import dev.humanbeeng.cryptoviewer.data.remote.dto.CoinDetailsDto
import dev.humanbeeng.cryptoviewer.data.remote.dto.CoinDto
import dev.humanbeeng.cryptoviewer.domain.model.Coin
import dev.humanbeeng.cryptoviewer.domain.model.CoinDetails
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

     fun getAllCoins(): Flow<Resource<List<Coin>>>

     fun getCoinDetails(coinId: String): Flow<Resource<CoinDetails>>
}