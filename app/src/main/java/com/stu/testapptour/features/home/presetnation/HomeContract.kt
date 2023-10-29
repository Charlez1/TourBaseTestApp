package com.stu.testapptour.features.home.presetnation

import androidx.compose.runtime.Stable
import com.stu.testapptour.features.home.domain.entity.home.ButtonInfo
import com.stu.testapptour.features.home.domain.entity.home.MainPageSection
import com.stu.testapptour.utils.UnidirectionalViewModel

@Stable
interface HomeContract: UnidirectionalViewModel<HomeContract.State, HomeContract.Event> {

    @Stable
    data class State(
        val isLoading: Boolean = false,
        val buttonList: List<ButtonInfo>? = null,
        val sectionList: List<MainPageSection>? = null
    )

    @Stable
    sealed class Event {
        data object OnGetMainPageData : Event()
    }
}
