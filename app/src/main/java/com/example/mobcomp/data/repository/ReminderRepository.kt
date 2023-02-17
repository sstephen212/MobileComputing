package com.example.mobcomp.data.repository

import android.provider.CalendarContract.Reminders
import com.example.mobcomp.data.entity.Reminder
import com.example.mobcomp.data.room.ReminderDao
import kotlinx.coroutines.flow.Flow

/**
 * * Data repository for [Reminder] instances
 */
class ReminderRepository (
    private val reminderDao: ReminderDao
        ){
    val listReminders = reminderDao.listReminders()
    fun getRemindersWithId (reminderId: Long): Reminder? {
        return reminderDao.reminder(reminderId)
    }


    suspend fun addReminder(reminder: Reminder) = reminderDao.insert(reminder)

}