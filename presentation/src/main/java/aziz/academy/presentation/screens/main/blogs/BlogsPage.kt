package aziz.academy.presentation.screens.main.blogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import aziz.academy.presentation.ui.color.BackgroundColor

@Composable
fun BlogsPage(navController: NavController, viewModel: BlogPageViewModel) {

    val state = viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(horizontal = 16.dp)
    ) {

        val blogItems = state.value.blogData


        if (blogItems != null) {
            LazyColumn {
                items(blogItems.size) {
                    BlogItem(
                        title = blogItems[it].title ?: "",
                        image = blogItems[it].image ?: ""
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        } else {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(55.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }
}