package com.example.basicstatecodelab

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.mutate
import kotlinx.collections.immutable.toPersistentList

class WellnessViewModel : ViewModel() {
    private val _tasks = mutableStateOf(getWellnessTasks())
    val tasks: ImmutableList<WellnessTask>
        get() = _tasks.value

    fun remove(item: WellnessTask) {
        val index = _tasks.value.indexOf(item)
        if (index != -1) {
            _tasks.value = _tasks.value.mutate {
                it.removeAt(index)
            }
        }
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) {
        val index = _tasks.value.indexOf(item)
        if (index != -1) {
            _tasks.value = _tasks.value.mutate {
                it[index] = it[index].copy(checked = checked)
            }
        }
    }
}

private fun getWellnessTasks() = (List(30) { i -> WellnessTask(i, "Task # $i") }).toPersistentList()
