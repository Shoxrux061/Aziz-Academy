package aziz.academy.presentation.screens.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import aziz.academy.presentation.R
import aziz.academy.presentation.screens.course_details.CourseDetailsModel
import aziz.academy.presentation.ui.color.GraySemiTransparent
import aziz.academy.presentation.ui.color.ThemePrimary
import com.google.accompanist.pager.HorizontalPagerIndicator

@Composable
fun CoursesPage(
    viewModel: HomePageViewModel,
    navController: NavController,
    onNext: (screenModel: CourseDetailsModel) -> Unit
) {

    val state = viewModel.state.collectAsState()

    val pagerState = rememberPagerState(pageCount = { state.value.homeData?.carousel?.size ?: 0 })

    if (state.value.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(55.dp),
                color = ThemePrimary
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            // контент
            item {
                IconButton(
                    modifier = Modifier.padding(vertical = 20.dp),
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_search),
                        contentDescription = null
                    )
                }
            }

            item {
                Box(modifier = Modifier.fillMaxWidth()) {
                    val carouselItems = state.value.homeData?.carousel
                    HorizontalPager(state = pagerState) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(220.dp)
                        ) {
                            CarouselItem(carouselItems?.get(it)?.imageUrl ?: "")
                        }
                    }
                    HorizontalPagerIndicator(
                        pagerState,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 10.dp),
                        pageCount = pagerState.pageCount,
                        activeColor = ThemePrimary,
                        inactiveColor = GraySemiTransparent,
                        indicatorWidth = 8.dp,
                        spacing = 8.dp
                    )
                }
            }

            // Контент курса
            item {
                val coursesData = state.value.homeData?.course

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .padding(top = 40.dp)
                        .heightIn(max = 10000.dp),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(coursesData?.size ?: 0) {
                        CourseItem(
                            image = coursesData?.get(it)?.imageUrl ?: "",
                            title = coursesData?.get(it)?.name ?: "unknown",
                            description = coursesData?.get(it)?.description ?: "unknown",
                            onItemClicked = {
                                val itemData = state.value.homeData?.course?.get(it)
                                val course = CourseDetailsModel(
                                    name = itemData?.name ?: "",
                                    description = itemData?.description ?: "",
                                    duration = "${itemData?.durationInMonths} oy",
                                    info = itemData?.topics ?: "",
                                    image = itemData?.imageUrl ?: "",
                                    price = itemData?.monthlyFee + " so'm"
                                )
                                onNext.invoke(course)
                            }
                        )
                    }
                }
            }
        }
    }
}
