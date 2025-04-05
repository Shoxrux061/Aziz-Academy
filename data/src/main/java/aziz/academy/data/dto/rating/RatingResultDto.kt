package aziz.academy.data.dto.rating

import com.google.gson.annotations.SerializedName


data class RatingResultDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("student")
    val student: StudentDto,
    @SerializedName("total_score")
    val totalScore: Int
)