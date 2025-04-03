package aziz.academy.presentation.screens.course_details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class CourseDataViewModel : ViewModel() {

    val courseData = mutableStateOf(
        CourseDetailsModel(
            description = "",
            duration = "",
            name = "",
            image = "",
            price = "",
            info = ""
        )
    )

    fun updateCourseData(newData: CourseDetailsModel) {
        courseData.value = newData
    }

}