package aziz.academy.data.dto.rating

import com.google.gson.annotations.SerializedName


data class StudentDto(
    @SerializedName("course")
    val course: String,
    @SerializedName("fullname")
    val fullname: String,
    @SerializedName("group")
    val group: String
)