package aziz.academy.data.mapper

import aziz.academy.data.dto.blog.BlogItemDto
import aziz.academy.data.dto.carousel.CarouselItemDto
import aziz.academy.data.dto.courses.BranchDto
import aziz.academy.data.dto.courses.CourseDto
import aziz.academy.data.dto.rating.RatingDto
import aziz.academy.data.dto.rating.RatingResultDto
import aziz.academy.data.dto.rating.StudentDto
import aziz.academy.domain.model.home.blog.BlogDataItem
import aziz.academy.domain.model.home.carousel.CarouselItem
import aziz.academy.domain.model.home.courses.Branch
import aziz.academy.domain.model.home.courses.Course
import aziz.academy.domain.model.home.rating.RatingResult
import aziz.academy.domain.model.home.rating.Student

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

fun BlogItemDto.toDomain(): BlogDataItem {

    return BlogDataItem(
        content = this.content,
        slug = this.slug,
        created_at = this.createdAt,
        dislikes = this.dislikes,
        likes = this.likes,
        views = this.views,
        excerpt = this.excerpt,
        id = this.id,
        image = this.image,
        title = this.title,
        updated_at = this.updatedAt
    )
}

fun RatingResultDto.toDomain(): RatingResult {

    return RatingResult(
        rank = this.rank,
        id = this.id,
        totalScore = this.totalScore,
        student = this.student.toDomain()
    )

}

fun StudentDto.toDomain(): Student {
    return Student(
        fullName = this.fullname,
        course = this.course,
        group = this.group
    )
}