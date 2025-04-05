package aziz.academy.data.dto.rating

import com.google.gson.annotations.SerializedName


data class RatingDto(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: List<RatingResultDto>
)