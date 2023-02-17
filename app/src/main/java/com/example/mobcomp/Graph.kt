package com.example.mobcomp

import android.content.Context
import androidx.room.Room
import com.example.mobcomp.data.repository.ReminderRepository
import com.example.mobcomp.data.room.MobCompDatabase


object Graph {


  //  val database by lazy { MobCompDatabase.provide(this) }
  //  val reminderRepository by lazy { ReminderRepository(database.ReminderDao()) }

   lateinit var database: MobCompDatabase

        private set

    val reminderRepository by lazy {
        ReminderRepository(
            reminderDao = database.reminderDao()
        )

    }

    fun provide (context: Context) {
        database = Room.databaseBuilder (context, MobCompDatabase::class.java, "mcData.db")
            .fallbackToDestructiveMigration () // don't use this in production app.
            .build()
    }

}
