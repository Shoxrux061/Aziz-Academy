package aziz.academy.domain.model.home.rating

data class RatingResult(
    val id: Int,
    val rank: Int,
    val student: Student,
    val totalScore: Int
)