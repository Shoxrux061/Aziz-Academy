package aziz.academy.presentation.screens.main.rating

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import aziz.academy.domain.model.home.rating.Student
import aziz.academy.presentation.R
import aziz.academy.presentation.ui.color.BackgroundColor
import aziz.academy.presentation.ui.color.Gray
import aziz.academy.presentation.ui.color.GrayLight
import aziz.academy.presentation.ui.color.GraySemiTransparent
import aziz.academy.presentation.ui.color.RankFirst
import aziz.academy.presentation.ui.color.RankSecond
import aziz.academy.presentation.ui.color.RankThird

@Composable
fun RatingItem(
    rank: Int,
    student: String,
    totalScore: Int
) {
    Column {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    when (rank) {
                        1 -> RankFirst
                        2 -> RankSecond
                        3 -> RankThird
                        else -> BackgroundColor
                    }
                )
                .padding(horizontal = 20.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = rank.toString(),
                fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                fontSize = 22.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.width(10.dp))

            Image(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(GrayLight)
                    .padding(10.dp),
                painter = painterResource(R.drawable.ic_person_placeholder),
                contentDescription = null
            )

            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = student,
                fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                fontSize = 16.sp

            )

            Box(modifier = Modifier.fillMaxWidth()) {

                Text(
                    text = totalScore.toString(),
                    modifier = Modifier.align(Alignment.CenterEnd),
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 18.sp
                )

            }

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(GrayLight)
        )

    }

}