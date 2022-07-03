package com.geekbrains.activitytofragment.data

import com.geekbrains.activitytofragment.domain.TestEntityData
import com.geekbrains.activitytofragment.domain.TestRepository
import java.util.*

class MemoryTestRepositoryImpl : TestRepository {

    private val position = "position"
    private fun generateId() = UUID.randomUUID().toString() // Генерируем уникальный ID

    override fun getTextFun(): List<TestEntityData> {
        return listOf(
            TestEntityData(generateId(), "0 $position", 0),
            TestEntityData(generateId(), "1 $position", 1),
            TestEntityData(generateId(), "2 $position", 2),
            TestEntityData(generateId(), "3 $position", 3),
            TestEntityData(generateId(), "4 $position", 4),
            TestEntityData(generateId(), "5 $position", 5),
            TestEntityData(generateId(), "6 $position", 6),
            TestEntityData(generateId(), "7 $position", 7),
            TestEntityData(generateId(), "8 $position", 8)
        )
    }

}