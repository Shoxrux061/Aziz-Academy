package aziz.academy.domain.model.home.courses

data class Course(
    val branch: Branch?,
    val description: String?,
    val durationInMonths: Int?,
    val id: Int?,
    val imageUrl: String?,
    val monthlyFee: String?,
    val name: String?,
    val topics: String?
)