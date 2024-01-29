import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Locale


class DataDiffTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    val sdf = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
    val sdf1 = SimpleDateFormat("MMM dd, YYYY", Locale.US)

    sealed interface DateDiffType {
        data class SECOND(val second: Long) : DateDiffType
        data class MINUTE(val minute: Long) : DateDiffType
        data class Hour(val hour: Int) : DateDiffType
        data class DATE(val date: Int) : DateDiffType
        data class WEEK(val week: Int) : DateDiffType
    }

    @Test
    fun formattedDate(createDate: String) {
        var result = ""
        try {
            result = sdf1.format(sdf.parse(createDate))

            val ldt = LocalDateTime.now()

            val date = sdf.parse(createDate)
            val instant: Instant = date.toInstant()
            val local = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())

            val duration = Duration.between(local, ldt);

            if (duration.seconds < 60) {
                DateDiffType.SECOND(duration.seconds)
                println("second diff : ${duration.seconds}초 전")
            } else if (duration.seconds > 60 && duration.toMinutes() < 1) {
                DateDiffType.MINUTE(duration.toMinutes())
                println("minute diff : ${duration.toMinutes()}분 전")
            } else if (duration.toMinutes() in 2..6) {
                DateDiffType.MINUTE(duration.toDays())
                println("date diff : ${duration.toDays()}일 전")
            } else {
                DateDiffType.MINUTE(duration.toDays())
                println("weeks diff : ${duration.toDays() / 7}주 전")
            }


        } catch (e: Exception) {
            System.out.println(e)
        }
        println(result)
    }

    @Test
    fun testFormattedDate() {
        formattedDate("2024-01-28 21:47:50")
        formattedDate("2023-01-28 21:47:50")
    }

    @Test
    fun test() {

    }

}