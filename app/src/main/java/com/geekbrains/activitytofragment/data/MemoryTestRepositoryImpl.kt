package com.geekbrains.activitytofragment.data

import com.geekbrains.activitytofragment.domain.TestEntityData
import com.geekbrains.activitytofragment.domain.TestRepository
import java.util.*

class MemoryTestRepositoryImpl : TestRepository {

    override fun getTextFun(): List<TestEntityData> {
        return listOf(
            TestEntityData(generateId(), "0 text test", 0),
            TestEntityData(generateId(), "1 text test", 1),
            TestEntityData(generateId(), "2 text test", 2),
            TestEntityData(generateId(), "3 text test", 3),
            TestEntityData(generateId(), "4 text test", 4),
            TestEntityData(generateId(), "5 text test", 5),
            TestEntityData(generateId(), "6 text test", 6),
            TestEntityData(generateId(), "7 text test", 7),
            TestEntityData(generateId(), "8 text test", 8)
        )
    }

    private fun generateId() = UUID.randomUUID().toString() // Генерируем уникальный ID
}