package aziz.academy.data.mapper

import aziz.academy.data.dto.carousel.CarouselItemDto
import aziz.academy.data.dto.courses.BranchDto
import aziz.academy.data.dto.courses.CourseDto
import aziz.academy.domain.model.home.carousel.CarouselItem
import aziz.academy.domain.model.home.courses.Branch
import aziz.academy.domain.model.home.courses.Course

fun CourseDto.toDomain(): Course {
    return Course(
        id = this.id,
        description = this.description,
        durationInMonths = this.duration_in_months,
        imageUrl = this.image_url,
        monthlyFee = this.monthly_fee,
        name = this.name,
        topics = this.topics,
        branch = this.branch?.toDomain()
    )
}

fun BranchDto.toDomain(): Branch {

    return Branch(
        address = this.address,
        id = this.id,
        locationIframe = this.location_iframe,
        name = this.name
    )
}

fun CarouselItemDto.toDomain(): CarouselItem {
    return CarouselItem(
        caption = this.caption,
        imageUrl = this.imageUrl,
        carousel = this.carousel,
        id = this.id,
        order = this.order
    )
}