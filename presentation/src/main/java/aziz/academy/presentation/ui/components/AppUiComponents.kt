package aziz.academy.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import aziz.academy.presentation.R
import aziz.academy.presentation.ui.color.BlueLight
import aziz.academy.presentation.ui.color.ThemeSecondary

@Composable
fun ImagePlaceholder(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
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