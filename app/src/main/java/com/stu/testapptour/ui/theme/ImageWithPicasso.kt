@file:OptIn(ExperimentalCoroutinesApi::class)

package com.stu.testapptour.ui.theme

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import com.squareup.picasso.Picasso
import com.stu.testapptour.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

@Composable
fun LoadPicassoImage(
    url: String,
    contentDescription: String? = null,
    modifier: Modifier = Modifier
) {
    val bitmapState = remember(url) { mutableStateOf<Bitmap?>(null) }

    LaunchedEffect(url) {
        val loadedBitmap = loadBitmapWithPicasso(url)
        bitmapState.value = loadedBitmap
    }

    if(bitmapState.value == null) {
        Image(
            painter = painterResource(id = R.drawable.placeholder),
            contentDescription = null, // decorative element
            modifier = modifier,
        )
    } else {
        bitmapState.value?.asImageBitmap()?.let { bitmap ->
            Image(
                bitmap = bitmap,
                contentDescription = contentDescription,
                modifier = modifier,
            )
        }
    }

}

private suspend fun loadBitmapWithPicasso(url: String): Bitmap = withContext(Dispatchers.IO) {
    suspendCancellableCoroutine<Bitmap> { continuation ->
        try {
            val bitmap = Picasso.get().load(url).get()
            continuation.resume(bitmap)
        } catch (e: Exception) {
            continuation.resumeWithException(e)
        }
    }
}