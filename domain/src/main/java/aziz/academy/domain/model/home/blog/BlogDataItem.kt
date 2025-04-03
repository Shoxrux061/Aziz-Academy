package aziz.academy.domain.model.home.blog

data class BlogDataItem(
    val content: String?,
    val created_at: String?,
    val dislikes: Int?,
    val excerpt: String?,
    val id: Int?,
    val image: String?,
    val likes: Int?,
    val slug: String?,
    val title: String?,
    val updated_at: String?,
    val views: Int?
)