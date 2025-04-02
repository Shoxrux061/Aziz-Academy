package aziz.academy.data.dto.courses


import com.google.gson.annotations.SerializedName

data class CoursesResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<CourseDto>
)