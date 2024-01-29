import com.sarang.torang.util.DateConverter.transformDate
import org.junit.Assert.assertEquals
import org.junit.Test


class DataDiffTest {
    @Test
    fun additionIscorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testFormattedDate() {
        transformDate("2024-01-28 21:47:50")
        transformDate("2024-01-27 21:47:50")
        transformDate("2024-01-25 21:47:50")
        transformDate("2024-01-22 21:47:50")
        transformDate("2023-01-28 21:47:50")
    }

    @Test
    fun test() {

    }

}