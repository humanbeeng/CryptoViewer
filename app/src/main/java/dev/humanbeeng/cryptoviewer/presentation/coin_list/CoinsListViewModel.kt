package dev.humanbeeng.cryptoviewer.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.humanbeeng.cryptoviewer.common.Resource
import dev.humanbeeng.cryptoviewer.domain.usecase.getcoins.GetCoinsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CoinsListViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase) :
    ViewModel() {

    private val _state = mutableStateOf(CoinsListState())
    val state: State<CoinsListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { resourceItem ->
            when (resourceItem) {
                is Resource.Loading -> {
                    _state.value = CoinsListState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinsListState(coins = resourceItem.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinsListState(
                        error = resourceItem.message ?: "Something unexpected has happened "
                    )
                }
            }
        }.launchIn(viewModelScope)
    }


}
