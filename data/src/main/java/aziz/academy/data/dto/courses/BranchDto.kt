package aziz.academy.data.dto.courses

import com.google.gson.annotations.SerializedName

data class BranchDto(
    @SerializedName("address")
    val address: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("location_iframe")
    val location_iframe: String?,
    @SerializedName("name")
    val name: String?
)