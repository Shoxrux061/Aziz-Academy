package aziz.academy.data.dto.courses

import com.google.gson.annotations.SerializedName

data class CourseDto(
    @SerializedName("branch")
    val branch: BranchDto?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("duration_in_months")
    val duration_in_months: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image_url")
    val image_url: String?,
    @SerializedName("monthly_fee")
    val monthly_fee: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("topics")
    val topics: String?
)