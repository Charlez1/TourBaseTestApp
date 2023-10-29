package com.stu.testapptour.features.home.presetnation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.stu.testapptour.features.home.domain.entity.blog.BlogItem
import com.stu.testapptour.features.home.domain.entity.`object`.ObjectItem
import com.stu.testapptour.features.home.domain.entity.room.RoomItem
import com.stu.testapptour.ui.theme.ContentCard
import com.stu.testapptour.utils.use

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigateToBlogScreen: (blogId: Int) -> Unit
) {
    val (state, event) = use(viewModel = viewModel)

    LaunchedEffect(key1 = Unit) {
        if(state.sectionList == null && state.buttonList == null)
            event.invoke(HomeContract.Event.OnGetMainPageData)
    }

    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else
        HomeScreenContent(
            state = state,
            onNavigateToBlogScreen = onNavigateToBlogScreen
        )
}

@Composable
fun HomeScreenContent(
    state: HomeContract.State,
    onNavigateToBlogScreen: (blogId: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        repeat(state.sectionList?.size ?: 0) { index ->
            item {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    text = state.sectionList?.get(index)?.title ?: "",
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = MaterialTheme.colorScheme.primary
                    ),
                    color = MaterialTheme.colorScheme.primary
                )
            }
            val contentSection = state.sectionList?.get(index)
            val contentItemsChunked = contentSection?.data?.chunked(2)

            items(
                contentItemsChunked?.size ?: 0
            ) { contentIndex ->
                val contentItem = contentItemsChunked?.get(contentIndex) ?: emptyList()
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    val leftContent = contentItem.first()
                    ContentCard(
                        content = leftContent,
                        modifier = Modifier.weight(1f),
                        onClick = {
                            when (leftContent) {
                                is ObjectItem -> {}
                                is RoomItem -> {}
                                is BlogItem -> onNavigateToBlogScreen(leftContent.id)
                                else -> {}
                            }
                        }
                    )
                    if (contentItem.size == 2) {
                        val rightContent = contentItem.last()
                        ContentCard(
                            content = rightContent,
                            modifier = Modifier.weight(1f),
                            onClick = {
                                when (rightContent) {
                                    is ObjectItem -> {}
                                    is RoomItem -> {}
                                    is BlogItem -> onNavigateToBlogScreen(rightContent.id)
                                    else -> {}
                                }
                            }
                        )
                    } else
                        Box(modifier = Modifier.weight(1f))
                }
            }
            item {
                if(index != (state.sectionList?.size?.minus(1) ?: 0)) {
                    Divider(
                        color = MaterialTheme.colorScheme.outline,
                        thickness = 1.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                }
            }
        }
    }
}
