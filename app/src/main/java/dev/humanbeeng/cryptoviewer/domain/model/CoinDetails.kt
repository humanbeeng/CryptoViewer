package dev.humanbeeng.cryptoviewer.domain.model

import dev.humanbeeng.cryptoviewer.data.remote.dto.TeamMember

data class CoinDetails(
    val name: String,
    val coinId: String,
    val description: String,
    val isActive: Boolean,
    val rank: Int,
    val symbol: String,
    val tags: List<String>,
    val team: List<TeamMember>
)
