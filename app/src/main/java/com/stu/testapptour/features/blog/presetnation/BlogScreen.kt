package com.stu.testapptour.features.blog.presetnation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.stu.testapptour.R
import com.stu.testapptour.features.blog.domain.entity.BlogInfo
import com.stu.testapptour.ui.theme.LoadPicassoImage
import com.stu.testapptour.utils.use
import dev.jeziellago.compose.markdowntext.MarkdownText
import java.text.SimpleDateFormat

@Composable
fun BlogScreen(
    viewModel: BlogViewModel = hiltViewModel(),
    blogId: Int,
    onNavigateBack: () -> Unit
) {
    val (state, event) = use(viewModel = viewModel)

    LaunchedEffect(key1 = Unit) {
        if(state.blogInfo == null)
            event.invoke(BlogContract.Event.OnGetBlogInfoData(blogId))
    }
    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else if(state.blogInfo != null) {
        BlogScreenContent(
            blogInfo = state.blogInfo,
            onNavigateBack = onNavigateBack
        )
    }
}

@Composable
fun BlogScreenContent(
    blogInfo: BlogInfo,
    onNavigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box {

            LoadPicassoImage(
                url = blogInfo.image.large,
            )
            Box(
                modifier = Modifier
                    .padding(start = 20.dp, top = 20.dp)
                    .size(40.dp)
                    .background(color = MaterialTheme.colorScheme.background, shape = CircleShape)
            ) {
                IconButton(
                    onClick = onNavigateBack,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                        contentDescription = "Back Icon",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
        
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = SimpleDateFormat("dd.MM.yyyy").format(blogInfo.date),
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = MaterialTheme.colorScheme.secondary,
                ),
            )
            Text(
                text = blogInfo.title,
                style = MaterialTheme.typography.titleLarge.copy(
                    color = MaterialTheme.colorScheme.primary,
                ),
            )
            Divider(
                color = MaterialTheme.colorScheme.outline,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )

            MarkdownText(
                markdown = blogInfo.content,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                linkColor = MaterialTheme.colorScheme.secondary
            )
        }
    }
}