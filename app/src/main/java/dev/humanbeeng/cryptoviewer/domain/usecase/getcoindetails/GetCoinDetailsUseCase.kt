package dev.humanbeeng.cryptoviewer.domain.usecase.getcoindetails

import dev.humanbeeng.cryptoviewer.common.Resource
import dev.humanbeeng.cryptoviewer.domain.model.CoinDetails
import dev.humanbeeng.cryptoviewer.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinDetailsUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> {
        return repository.getCoinDetails(coinId)
    }

}