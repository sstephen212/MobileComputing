package com.example.mobcomp.data.room

import androidx.room.*
import com.example.mobcomp.data.entity.Reminder
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ReminderDao {
    // search query here
    @Query( """SELECT * FROM reminders WHERE id = :reminderId""")
    abstract fun reminder (reminderId: Long):  Reminder?
    @Query( """SELECT * FROM reminders """)
    abstract fun listReminders (): Flow <List<Reminder>>

   // @Query("UPDATE Reminder SET isComplete=:isComplete WHERE id= :id")
    //abstract suspend fun updateReminder (entity: isComplete): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert (entity: Reminder): Long
    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun update (entity: Reminder)
    @Delete
    abstract suspend fun delete(entity: Reminder): Int
}