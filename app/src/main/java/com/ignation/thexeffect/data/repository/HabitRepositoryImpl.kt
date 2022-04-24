package com.ignation.thexeffect.data.repository

import com.ignation.thexeffect.data.local.HabitDatabase
import com.ignation.thexeffect.data.mapper.toBoardEntity
import com.ignation.thexeffect.data.mapper.toWeekEntityList
import com.ignation.thexeffect.domain.models.Board
import com.ignation.thexeffect.domain.models.Week
import com.ignation.thexeffect.domain.repository.HabitRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HabitRepositoryImpl @Inject constructor(
    private val db: HabitDatabase
) : HabitRepository {

    private val dao = db.habitDao()

    override suspend fun createHabit(board: Board, weeks: List<Week>?) {
        withContext(Dispatchers.IO) {
            val id = dao.insertBoard(board.toBoardEntity())
            if (weeks != null) {
                dao.insertWeeks(weeks.toWeekEntityList(id))
            }
        }
    }

    override suspend fun getActiveHabits(): Flow<List<Board>> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteHabit(board: Board) {
        withContext(Dispatchers.IO) {
            db.habitDao().deleteHabit(board.toBoardEntity())
        }
    }
}