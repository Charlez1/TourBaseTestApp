package com.stu.testapptour.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import kotlinx.coroutines.flow.StateFlow

data class StateDispatch<STATE, EVENT> (
    val state: STATE,
    val dispatch: (EVENT) -> Unit,
)

@Composable
inline fun <reified STATE, EVENT> use(viewModel: UnidirectionalViewModel<STATE, EVENT>): StateDispatch<STATE, EVENT> {
    val state by viewModel.state.collectAsState()

    val dispatch: (EVENT) -> Unit = { event ->
        viewModel.event(event)
    }
    return StateDispatch(
        state = state,
        dispatch = dispatch,
    )
}

interface UnidirectionalViewModel<STATE, EVENT> {
    val state: StateFlow<STATE>
    fun event(event: EVENT)
}
