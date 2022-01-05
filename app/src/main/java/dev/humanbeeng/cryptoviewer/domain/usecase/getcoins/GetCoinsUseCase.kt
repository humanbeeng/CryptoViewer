package dev.humanbeeng.cryptoviewer.domain.usecase.getcoins

import dev.humanbeeng.cryptoviewer.common.Resource
import dev.humanbeeng.cryptoviewer.domain.model.Coin
import dev.humanbeeng.cryptoviewer.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Coin>>> {
        return repository.getAllCoins()
    }
}