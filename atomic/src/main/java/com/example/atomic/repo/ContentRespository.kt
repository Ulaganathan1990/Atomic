package com.example.atomic.repo

import com.example.atomic.model.Sport
import dagger.Module
import kotlinx.coroutines.delay

interface ContentRepository {

    suspend fun getFeaturedSports(): List<Sport> {
        delay(500)
        return Sport.createMockedSports()
    }
}