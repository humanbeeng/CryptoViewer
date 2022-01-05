package dev.humanbeeng.cryptoviewer.presentation.coin_details

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.humanbeeng.cryptoviewer.common.Constants
import dev.humanbeeng.cryptoviewer.common.Resource
import dev.humanbeeng.cryptoviewer.domain.usecase.getcoindetails.GetCoinDetailsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase,
    savedStateHandle: SavedStateHandle

) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.PAPRIKA_COIN_ID)
            ?.let { coinIdValueFromState -> getCoinDetails(coinIdValueFromState) }
        Log.d(
            "CoinDetails",
            "CoinDetailsScreen: invoked " + savedStateHandle.get(Constants.PAPRIKA_COIN_ID)
        )
    }

    private fun getCoinDetails(coinId: String) {
        Log.d("CoinDetails", "Called getCoinDetails func")


        getCoinDetailsUseCase(coinId).onEach { resourceItem ->
            when (resourceItem) {
                is Resource.Loading -> {
                    _state.value = CoinDetailsState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinDetailsState(coinDetails = resourceItem.data)
                    Log.d("CoinDetails", "getCoinDetails: " + _state.value.toString())
                }
                is Resource.Error -> {
                    _state.value = CoinDetailsState(
                        error = resourceItem.message ?: "Uh Oh ! Something unexpected has happened"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

}