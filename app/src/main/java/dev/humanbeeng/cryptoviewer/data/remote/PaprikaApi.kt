package dev.humanbeeng.cryptoviewer.data.remote

import dev.humanbeeng.cryptoviewer.data.remote.dto.CoinDetailsDto
import dev.humanbeeng.cryptoviewer.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PaprikaApi {

    @GET("/v1/coins")
    suspend fun getAllCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetails(@Path("coinId") coinId: String): CoinDetailsDto

}