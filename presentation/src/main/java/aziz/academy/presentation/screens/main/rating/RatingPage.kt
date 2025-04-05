package aziz.academy.presentation.screens.main.rating

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import aziz.academy.presentation.R
import aziz.academy.presentation.ui.color.BackgroundColor
import aziz.academy.presentation.ui.color.ThemePrimary

@Composable
fun RatingPage(navController: NavController, viewModel: RatingPageViewModel) {


    val state = viewModel.state.collectAsState()

    LaunchedEffect(state.value) {
        when {
            state.value.isLoading -> {
                Log.d("RatingPageState", "RatingPage: Loading")
            }

            state.value.ratingData != null -> {
                Log.d("RatingPageState", "RatingPage: Success ${state.value.ratingData}")
            }

            state.value.error != null -> {
                Log.d("RatingPageState", "RatingPage: Error ${state.value.error}")
            }
        }
    }

    val listState = rememberLazyListState()

    LaunchedEffect(listState) {
        snapshotFlow { listState.layoutInfo }
            .collect { layoutInfo ->
                val lastVisibleItemIndex = layoutInfo.visibleItemsInfo.lastOrNull()?.index
                val totalItemsCount = layoutInfo.totalItemsCount

                if (lastVisibleItemIndex == totalItemsCount - 1 && !state.value.isLoading) {

                    viewModel.sendEvent(RatingPageEvent.FetchRatingData())

                }
            }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor),
        state = listState
    ) {

        item {
            Text(
                text = "O'quvchilar reytingi",
                fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(vertical = 20.dp)
            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            ) {

                Text(
                    text = "Kurs:English",
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    fontSize = 16.sp,
                    color = ThemePrimary,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 20.dp)
                )

                Text(
                    text = "Ballar",
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    fontSize = 16.sp,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 20.dp)
                )
            }

        }

        val ratingData = state.value.ratingData

        items(ratingData?.size ?: 0) {

            if (ratingData != null) {

                RatingItem(
                    rank = ratingData[it].rank,
                    student = ratingData[it].student.fullName,
                    totalScore = ratingData[it].totalScore
                )

            } else {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(55.dp),
                        color = ThemePrimary
                    )
                }
            }
        }
    }
}