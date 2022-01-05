package dev.humanbeeng.cryptoviewer.data.repository

import dev.humanbeeng.cryptoviewer.common.Resource
import dev.humanbeeng.cryptoviewer.data.remote.PaprikaApi
import dev.humanbeeng.cryptoviewer.domain.model.Coin
import dev.humanbeeng.cryptoviewer.domain.model.CoinDetails
import dev.humanbeeng.cryptoviewer.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: PaprikaApi) : CoinRepository {
    override fun getAllCoins(): Flow<Resource<List<Coin>>> {
        return flow {
            try {
                emit(Resource.Loading())
                val coins = api.getAllCoins().map { it.toCoin() }
                emit(Resource.Success(coins))
            } catch (e: HttpException) {
                emit(Resource.Error(message = e.localizedMessage ?: "Uh oh! something went wrong."))
            } catch (e: IOException) {
                emit(
                    Resource.Error(
                        message = e.localizedMessage ?: "Please check your internet connection !"
                    )
                )
            }
        }
    }

    override fun getCoinDetails(coinId: String): Flow<Resource<CoinDetails>> =
        flow {
            try {
                emit(Resource.Loading())
                val coinDetails = api.getCoinDetails(coinId).toCoinDetails()
                emit(Resource.Success(coinDetails))
            } catch (e: IOException) {
                emit(
                    Resource.Error(
                        message = e.localizedMessage ?: "Please check your internet connection !"
                    )
                )
            } catch (e: HttpException) {
                emit(Resource.Error(message = e.localizedMessage ?: "Uh oh! Something went wrong"))
            }
        }
}
