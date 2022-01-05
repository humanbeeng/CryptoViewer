package dev.humanbeeng.cryptoviewer.data.remote.dto


import com.google.gson.annotations.SerializedName
import dev.humanbeeng.cryptoviewer.domain.model.CoinDetails

data class CoinDetailsDto(
    @SerializedName("description")
    val description: String,
    @SerializedName("development_status")
    val developmentStatus: String,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String,
    @SerializedName("id")
    val coinId: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("last_data_at")
    val lastDataAt: String,
    @SerializedName("links")
    val links: Links,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended>,
    @SerializedName("message")
    val message: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("org_structure")
    val orgStructure: String,
    @SerializedName("proof_type")
    val proofType: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("started_at")
    val startedAt: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("tags")
    val tags: List<Tag> = emptyList(),
    @SerializedName("team")
    val team: List<TeamMember> = emptyList(),
    @SerializedName("type")
    val type: String,
    @SerializedName("whitepaper")
    val whitepaper: Whitepaper
) {
    fun toCoinDetails(): CoinDetails {
        return CoinDetails(
            symbol = symbol,
            name = name,
            isActive = isActive,
            description = description,
            coinId = coinId,
            rank = rank,
            tags = tags.map { it.name },
            team = team
        )

    }
}