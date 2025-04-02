package aziz.academy.data.dto.carousel

import com.google.gson.annotations.SerializedName


data class CarouselItemDto(
    @SerializedName("caption")
    val caption: String?,
    @SerializedName("carousel")
    val carousel: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("order")
    val order: Int?
)