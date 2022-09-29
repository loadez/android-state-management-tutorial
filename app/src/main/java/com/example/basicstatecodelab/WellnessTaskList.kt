package com.example.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.collections.immutable.ImmutableList

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckedChange: (WellnessTask, Boolean) -> Unit,
    list: ImmutableList<WellnessTask>
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list, key = { it.hashCode() }) { item ->
            WellnessTaskItem(
                taskName = item.label,
                checked = item.checked,
                onClose = { onCloseTask(item) },
                onCheckedChange = { checked -> onCheckedChange(item, checked) }
            )
        }
    }
}
