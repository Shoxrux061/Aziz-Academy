package aziz.academy.presentation.screens.course_details

import java.io.Serializable

data class CourseDetailsModel(

    val name: String,
    val description: String,
    val image: String,
    val price: String,
    val info: String,
    val duration: String

) : Serializable
