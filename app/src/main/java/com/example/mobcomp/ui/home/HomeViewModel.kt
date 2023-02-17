package com.example.mobcomp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobcomp.Graph
import com.example.mobcomp.Graph.reminderRepository
import com.example.mobcomp.data.entity.Reminder
import com.example.mobcomp.data.repository.ReminderRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class HomeViewModel(
    private val reminderRepository: ReminderRepository = Graph.reminderRepository
) : ViewModel() {
    private val _state = MutableStateFlow(HomeViewState())
   // private val _selectedCategory = MutableStateFlow<Category?>(null)
    val state: StateFlow<HomeViewState>
        get() =_state

    val RemindersList = reminderRepository.listReminders
//    fun onCategorySelected(category: Category){
    //    _selectedCategory.value =category
  //  }
    init {
        //viewModelScope.launch {
          //  _state.value = it
        //}
   // loadRemindersFromDb()
    }

    private fun loadRemindersFromDb(){
        val list = mutableListOf(
            Reminder(1,"Health", 12012023),
            Reminder(2, "Savings", 18012020),
            Reminder(3, "Drinks", 23122021)

        )
        viewModelScope.launch {
            list.forEach { reminder -> reminderRepository.addReminder(reminder) }
        }
    }

}


data class HomeViewState(
    val reminders: List<Reminder> = emptyList(),
 //   val selectedCategory: Reminder? = null
)