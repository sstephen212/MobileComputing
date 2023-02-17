package com.example.mobcomp.data.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mobcomp.Graph
//import com.example.mobcomp.Graph
import com.example.mobcomp.data.entity.Reminder

@Database(
    entities = [Reminder::class],
    version = 1,
    exportSchema = false
)
abstract class MobCompDatabase : RoomDatabase() {
    abstract fun reminderDao(): ReminderDao


}


