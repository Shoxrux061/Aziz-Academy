package aziz.academy.presentation.screens.course_details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import aziz.academy.presentation.R
import aziz.academy.presentation.ui.color.BackgroundColor
import aziz.academy.presentation.ui.color.TextPrimary
import aziz.academy.presentation.ui.color.ThemePrimary
import aziz.academy.presentation.ui.color.ThemeSecondary
import aziz.academy.presentation.ui.components.ImagePlaceholder
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

@Composable
fun CourseDetailsScreen(screenModel: CourseDetailsModel) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(horizontal = 16.dp)
            .verticalScroll(scrollState),
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(220.dp),

            colors = CardDefaults.cardColors(
                containerColor = ThemeSecondary
            )
        ) {
            SubcomposeAsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(screenModel.image)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                loading = {
                    ImagePlaceholder()
                },
                error = {
                    ImagePlaceholder()
                }
            )
        }

        Text(
            text = screenModel.name,
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
            color = ThemePrimary
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = screenModel.description,
            color = TextPrimary,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            fontSize = 14.sp,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Kurs davomiyligi: ${screenModel.duration}"
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier
                .padding()
                .align(Alignment.End),
            border = BorderStroke(width = 2.dp, color = ThemePrimary),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = ThemeSecondary
            )
        ) {

            Text(
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp),
                text = screenModel.price,
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular))
            )

        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Mavzular",
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
            fontSize = 16.sp,
            color = ThemePrimary
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            fontSize = 12.sp,
            lineHeight = 20.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            text = screenModel.description
        )
    }
}