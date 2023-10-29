package com.stu.testapptour.features.home.presetnation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stu.testapptour.features.home.domain.usecase.GetMainPageDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMainPageDataUseCase: GetMainPageDataUseCase
) : ViewModel(), HomeContract {

    private val mutableScreenState = MutableStateFlow(HomeContract.State())
    override val state: StateFlow<HomeContract.State> = mutableScreenState.asStateFlow()

    override fun event(event: HomeContract.Event) {
        when (event) {
            is HomeContract.Event.OnGetMainPageData -> getMainPageData()
        }
    }

    private fun getMainPageData() = viewModelScope.launch {
        mutableScreenState.update { it.copy(isLoading = true) }
        try {
            var mainPage = getMainPageDataUseCase.getMainPageData()
            mutableScreenState.update{
                it.copy(buttonList = mainPage.buttons, sectionList = mainPage.allSectionList)
            }
        } catch (e: Exception) {
            // todo handle exception
        } finally {
            mutableScreenState.update { it.copy(isLoading = false) }
        }
    }


}