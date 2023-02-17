package com.example.mobcomp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*
@Entity(
    tableName = "reminders",
    indices = [
        Index("id", unique = true)
    ]
)
data class Reminder(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val reminderId: Long =0,
   // @ColumnInfo(isComplete = "reminder_date") val isComplete: Boolean,
    @ColumnInfo(name = "reminder_message") val reminderMessage: String,
    @ColumnInfo(name = "reminder_date") val reminderDate: Long?
    //val paymentCategory: String
)
