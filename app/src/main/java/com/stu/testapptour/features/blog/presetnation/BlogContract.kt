package com.stu.testapptour.features.blog.presetnation

import androidx.compose.runtime.Stable
import com.stu.testapptour.features.blog.domain.entity.BlogInfo
import com.stu.testapptour.utils.UnidirectionalViewModel

interface BlogContract : UnidirectionalViewModel<BlogContract.State, BlogContract.Event> {

    @Stable
    data class State(
        val isLoading: Boolean = false,
        val blogInfo: BlogInfo? = null
    )

    @Stable
    sealed class Event {
        data class OnGetBlogInfoData(val blogId: Int) : Event()
    }
}
