package com.stu.testapptour.features.blog.presetnation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stu.testapptour.features.blog.domain.usecase.GetBlogInfoUseCase
import com.stu.testapptour.features.blog.repository.BlogRepository
import com.stu.testapptour.features.home.presetnation.HomeContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlogViewModel @Inject constructor(
    private val getBlogInfoUseCase: GetBlogInfoUseCase
): ViewModel(), BlogContract {

    private val mutableScreenState = MutableStateFlow(BlogContract.State())
    override val state: StateFlow<BlogContract.State> = mutableScreenState.asStateFlow()

    override fun event(event: BlogContract.Event) {
        when (event) {
            is BlogContract.Event.OnGetBlogInfoData -> getBlogInfoData(event.blogId)
        }
    }

    private fun getBlogInfoData(blogId: Int) = viewModelScope.launch {
        mutableScreenState.update { it.copy(isLoading = true) }
        try {
            val blogInfo = getBlogInfoUseCase.getBlogInfo(blogId)
            mutableScreenState.update { it.copy(blogInfo = blogInfo) }
        } catch (e: Exception) {
            // todo handle exception
        } finally {
            mutableScreenState.update { it.copy(isLoading = false) }
        }
    }
}