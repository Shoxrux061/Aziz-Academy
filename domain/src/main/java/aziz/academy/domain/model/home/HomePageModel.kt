package aziz.academy.domain.model.home

import aziz.academy.domain.model.home.carousel.CarouselItem
import aziz.academy.domain.model.home.courses.Course

data class HomePageModel(
    val course: List<Course>?,
    val carousel: List<CarouselItem>?
)
