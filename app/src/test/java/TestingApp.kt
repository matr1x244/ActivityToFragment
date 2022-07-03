import com.geekbrains.activitytofragment.data.MemoryTestRepositoryImpl
import com.geekbrains.activitytofragment.domain.TestEntityData
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TestingApp {

    lateinit var entityData: TestEntityData
    lateinit var memoryTestRepositoryImpl: MemoryTestRepositoryImpl

    @Before
    fun setUp(){
        entityData = TestEntityData(textId = "5", textView = "text", textNumber = 0)
        memoryTestRepositoryImpl = MemoryTestRepositoryImpl()
    }

    @Test
    fun startTesting(){
        Assert.assertEquals("5", entityData.textId)
        Assert.assertEquals("text", entityData.textView)
        Assert.assertEquals(0, memoryTestRepositoryImpl.getTextFun())
    }

}