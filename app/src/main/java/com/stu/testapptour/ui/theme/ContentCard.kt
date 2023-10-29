package com.stu.testapptour.ui.theme

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stu.testapptour.features.home.domain.entity.Content
import com.stu.testapptour.features.home.domain.entity.ObjectType
import com.stu.testapptour.features.home.domain.entity.blog.BlogItem
import com.stu.testapptour.features.home.domain.entity.`object`.ObjectItem
import com.stu.testapptour.features.home.domain.entity.room.RoomItem
import com.stu.testapptour.features.home.domain.entity.tour.TourItem

@Composable
fun ContentCard(
    content: Content,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    when(content) {
        is ObjectItem -> {
            ObjectContent(content = content, modifier = modifier, onClick = onClick)
        }
        is RoomItem -> {
            RoomContent(content = content, modifier = modifier, onClick = onClick)
        }
        is BlogItem -> {
            BlogContent(content = content, modifier = modifier, onClick = onClick)
        }
        is TourItem -> {
            TourContent(content = content, modifier = modifier, onClick = onClick)
        }
    }
}

@Composable
fun TourContent(
    content: TourItem,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier.clickable { onClick() },
    ) {
        LoadPicassoImage(
            url = content.image.medium,
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .fillMaxSize()
                .clip(RoundedCornerShape(size = 8.dp))
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "${content.date.date} / ${content.duration.day} дня ${content.duration.night} ночи",
            style = MaterialTheme.typography.headlineSmall.copy(
                color = MaterialTheme.colorScheme.primary,
            ),
            maxLines = 1
        )
        Text(
            text = content.title,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineMedium.copy(
                color = MaterialTheme.colorScheme.primary
            ),
            maxLines = 2
        )
        Spacer(modifier = Modifier.height(2.dp))

        Row {
            if(content.price.price != content.price.factPrice) {
                Text(
                    text = "${content.price.price}",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        color = MaterialTheme.colorScheme.secondary,
                        textDecoration = TextDecoration.LineThrough
                    ),
                    maxLines = 1
                )
                Text(
                    text = " ${content.price.factPrice}₽",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        color = MaterialTheme.colorScheme.error
                    ),
                    maxLines = 1
                )
            } else
                Text(
                    text = "${content.price.factPrice}₽",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        color = MaterialTheme.colorScheme.primary
                    ),
                    maxLines = 1
                )
        }
    }
}

@Composable
fun RoomContent(
    content: RoomItem,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier.clickable { onClick() },
    ) {
        LoadPicassoImage(
            url = content.image.medium,
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .fillMaxSize()
                .clip(RoundedCornerShape(size = 8.dp))
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "До ${content.countTourist} гостей",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineMedium.copy(
                color = MaterialTheme.colorScheme.primary
            ),
            maxLines = 1
        )
        Text(
            text = content.title,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineMedium.copy(
                color = MaterialTheme.colorScheme.primary
            ),
            maxLines = 1
        )
        Row {
            if(content.price.price != content.price.factPrice) {
                Text(
                    text = "${content.price.price}",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        color = MaterialTheme.colorScheme.secondary,
                        textDecoration = TextDecoration.LineThrough
                    ),
                    maxLines = 1
                )
                Spacer(modifier = Modifier.width(1.dp))
                Text(
                    text = " ${content.price.factPrice}₽ / ${content.type}",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        color = MaterialTheme.colorScheme.error
                    ),
                    maxLines = 1
                )
            } else
                Text(
                    text = "${content.price.factPrice}₽ / ${content.type}",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        color = MaterialTheme.colorScheme.primary
                    ),
                    maxLines = 1
                )
        }

    }
}

@Composable
fun ObjectContent(
    content: ObjectItem,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier.clickable { onClick() },
    ) {
        LoadPicassoImage(
            url = content.image.medium,
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .fillMaxSize()
                .clip(RoundedCornerShape(size = 8.dp))
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = content.title,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineMedium.copy(
                color = MaterialTheme.colorScheme.primary
            ),
            maxLines = 1
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = content.subtitle,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineSmall.copy(
                color = MaterialTheme.colorScheme.primary
            ),
            maxLines = 2
        )
    }
}

@Composable
fun BlogContent(
    content: BlogItem,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier.clickable { onClick() },
    ) {
        LoadPicassoImage(
            url = content.image.medium,
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .fillMaxSize()
                .clip(RoundedCornerShape(size = 8.dp))
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = content.title,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineMedium.copy(
                color = MaterialTheme.colorScheme.primary
            ),
            maxLines = 1
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = content.subtitle,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineSmall.copy(
                color = MaterialTheme.colorScheme.primary
            ),
            maxLines = 2
        )
    }
}
