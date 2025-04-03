package aziz.academy.presentation.screens.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import aziz.academy.presentation.R
import aziz.academy.presentation.ui.color.BlueLight
import aziz.academy.presentation.ui.color.GrayLight
import aziz.academy.presentation.ui.color.ThemeSecondary
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

@Composable
fun CourseItem(onItemClicked: () -> Unit, image: String, title: String, description: String) {

    Card(
        modifier = Modifier
            .height(168.dp)
            .width(189.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .clickable {
                onItemClicked.invoke()
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )

    ) {
        Column(

            modifier = Modifier
                .fillMaxSize()
                .background(GrayLight),
        ) {

            SubcomposeAsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(image)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                loading = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(ThemeSecondary),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.image),
                            contentDescription = "Placeholder Image",
                            tint = BlueLight,
                            modifier = Modifier.size(33.dp)
                        )
                    }

                }
            )

            Column(modifier = Modifier.padding(8.dp)) {

                Text(
                    text = title,
                    fontSize = 12.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = Color.Black
                )
                Text(
                    maxLines = 1,
                    text = description,
                    fontSize = 14.sp,
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = FontFamily(Font(R.font.poppins_medium))
                )
            }
        }
    }
}


@Composable
fun CarouselItem(image: String) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .background(ThemeSecondary)
    ) {

        SubcomposeAsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(image)
                .crossfade(true)
                .build(),
            loading = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(ThemeSecondary)
                ) {
                    Icon(
                        modifier = Modifier.align(Alignment.Center),
                        tint = BlueLight,
                        painter = painterResource(R.drawable.image),
                        contentDescription = null
                    )
                }
            },
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            contentDescription = null
        )
    }
}