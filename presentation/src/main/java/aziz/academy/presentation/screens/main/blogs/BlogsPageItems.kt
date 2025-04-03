package aziz.academy.presentation.screens.main.blogs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import aziz.academy.presentation.ui.color.ThemePrimary
import aziz.academy.presentation.ui.color.ThemeSecondary
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

@Composable
fun BlogItem(title: String, image: String) {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = ThemeSecondary
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                border = BorderStroke(width = 1.dp, color = ThemePrimary)
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
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                color = ThemePrimary,
                fontSize = 18.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                text = title
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    modifier = Modifier.padding(horizontal = 6.dp),
                    painter = painterResource(R.drawable.ic_unlike),
                    contentDescription = null
                )

                Text(
                    text = "12",
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.width(20.dp))

                Icon(
                    modifier = Modifier.padding(horizontal = 6.dp),
                    painter = painterResource(R.drawable.ic_comment),
                    contentDescription = null
                )

                Text(
                    text = "12",
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 14.sp
                )
            }
        }
    }
}