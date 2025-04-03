package aziz.academy.data.dto.blog


import com.google.gson.annotations.SerializedName

data class BlogItemDto(
    @SerializedName("content")
    val content: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("dislikes")
    val dislikes: Int?,
    @SerializedName("excerpt")
    val excerpt: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("likes")
    val likes: Int?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("views")
    val views: Int?
)