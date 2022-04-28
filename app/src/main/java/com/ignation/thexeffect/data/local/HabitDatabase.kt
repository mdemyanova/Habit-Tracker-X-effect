package com.ignation.thexeffect.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ignation.thexeffect.data.local.entities.BoardEntity
import com.ignation.thexeffect.data.local.entities.DayEntity
import com.ignation.thexeffect.data.local.entities.WeekEntity

@Database(
    entities = [
        BoardEntity::class,
        WeekEntity::class,
        DayEntity::class
    ], version = 7, exportSchema = false
)
abstract class HabitDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
}