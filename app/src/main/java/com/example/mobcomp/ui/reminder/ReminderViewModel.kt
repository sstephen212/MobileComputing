package com.example.mobcomp.ui.reminder

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.mobcomp.Graph
import com.example.mobcomp.data.entity.Reminder
import com.example.mobcomp.data.repository.ReminderRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ReminderViewModel (
    private val reminderRepository: ReminderRepository = Graph.reminderRepository
): ViewModel() {
    private val _state = MutableStateFlow(ReminderViewState())
    val state: StateFlow<ReminderViewState>
        get() = _state
    init {
        viewModelScope.launch {
            reminderRepository.listReminders.collect() { listReminders ->
                _state.value = ReminderViewState(listReminders)
            }
        }
    }

    suspend fun saveReminder(reminder: Reminder): Long {
        return reminderRepository.addReminder(reminder)
    }




}

data class ReminderViewState(
    val reminders: List<Reminder> = emptyList()
)
