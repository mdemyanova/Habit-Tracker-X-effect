package com.ignation.thexeffect.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ignation.thexeffect.model.Board
import com.ignation.thexeffect.model.Day

@Entity
data class Board(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val is_active: Boolean,
    val start_date: Long
)